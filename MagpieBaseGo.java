//to access arraylists and arrays
import java.util.ArrayList;
import java.util.List;

public class MagpieBaseGo{
   
   //starts off with greeting
   char lastNode = 'a';
   
   //needs to respond based on input? yes no question? automatic answer?
   List<Character> inputBased = new ArrayList<>(List.of('c', 'e', 'f', 'i', 'n', 'u'));
   List<Character> yesnoBased = new ArrayList<>(List.of('a', 'b', 'd', 'g', 'h', 'p', 't', 'v','x', '#', 'w', '0', '2', '4', '6', '!'));
   List<Character> automatic = new ArrayList<>(List.of('j', 'k', 'l', 'm', 'o', 'q', 'r', 's', 'y', 'z', '1', '3', '5', '7', '8', '9', '@'));
   
   //stores information for input based
   String myInstrument = " ";
   String myDescription = " ";
   String yourEra = " ";
   String myPiece = " ";
   String yourGenre = " ";
   String yourFeeling = " ";
   String yourComposer = " ";
   
   //at end of conversation, loop through random statements.
   String[] babbling = {"I have played violin for six years now.", 
   "I play for HPU's Community Orchestra.", "My favorite violinist is Itzhak Perlman.",
   "Did you know violin bows are made with horse hair?", "Secretly I'm very lonely.", 
   "You can go now. I'm running out of things to say."};
   int babble = 0;
   
   //if conversation topic has already been discussed
   boolean askedGenre = false;
   boolean suggestPiece = false;
   
   //instruments in orchestra
   //orchestra[0-4] string family (hah! string.)
   //orchestra[5-9] woodwind family
   //orchestra[10-13] brass family
   //orchestra[14-19] percussion family
   String[] orchestra = {"violin", "viola", "cello", "double bass",
   "harp", "flute", "piccolo", "oboe", "clarinet", "bassoon", 
   "trumpet", "french horn", "trombone", "tuba", 
   "piano", "timpani", "xylophone", "cymbals", "triangle", "snare drum"};
   
   //to identify family
   int orchFamily = 0;
   
   //eras and descriptions
   String[] eras = {"baroque", "classical", "romantic", "20th century"};
   int erasMatch = 0;
   String[] eraDescription = {"its use of ornamentation, intricacy, and dramatic contrast.", 
   "its graceful and simple melodies as well as a focus on a clean and balanced sound.",
   "its passionate melodies, longer works, and emphasis on emotion and self expression.", 
   "innovative approaches to tone and instrumentation, and a divergence from tradition."};
   
   //types of pieces and recommended pieces
   String[] format = {"sonata", "concerto", "duet"};
   int formatMatch = 0;
   String[] sonatas = {"Bach Violin Sonata no 1 in G minor", "Mozart Violin Sonata no 17 in C major", 
   "Beethoven Kreutzer Sonata", "Ravel Violin Sonata No 2."};
   String[] concertos = {"Bach Violin Concerto no 1 in A minor", "Mozart Violin Concerto no 5", 
   "Bruch Violin Concerto in G minor", "Shostakovich Violin Concerto no 1 in A minor"};
   String[] duets = {"Bach Double Violin Concerto in D minor",  "Mozart Duo for Violin and Viola in G Major", 
   "Passacaglia for Violin and Viola by Halvorsen", "Strauss Duet Concertino for Clarinet and Bassoon"};
   
   //other genres
   String[] genres = {"jazz", "kpop", "pop", "rock", "country", "blues", "electronic", "funk", "indie"};
   
   //emotions
   String[] feelings = {"happy", "nostagic", "sad", "energetic", "calm", "angry", "cool", "relaxed"};
 
   //various ways of saying yes
   List<String> affirmative = new ArrayList<>(List.of("yes", "sure", "alright", "okay", "ok", "yeah"));
	
   //composers 
   String[] composers = {"Mozart", "Beethoven", "Bach", "Chopin", "Rachmaninov"};
   
   //greet the user
   public String getGreeting(){
   
		//create your own greeting
      return("Hello, I am Maggie! Do you like classical music?");
	}
	
	public String getResponse(String statement)
	{
      //identifies next branch in conversation
      char nextNode = whereTo(statement.toLowerCase());
      
      //to avoid compilation error
      String response = "ERROR!";
      
      //returns a response and changes "lastNode" for future
      //either has a set statement or calls method to incorporate input
      switch(nextNode){
         case 'b':
            response = "Would you like to learn more about classical music?";
            lastNode = 'b';
            break;
         case 'c':
            response = "I like classical music too! What is your favorite orchestral instrument?";
            lastNode = 'c';
            break;
         case 'd':
            response = "Can I recommend an instrument for you?";
            lastNode = 'd';
            break;
         case 'e':
            response = nodeE(statement);
            lastNode = 'e';
            break;
         case 'f':
            askedGenre = true;
            response = "What other genre of music do you like?";
            lastNode = 'f';
            break;
         case 'g':
            response = nodeG(statement);
            lastNode = 'g';
            break;
         case 'h':
            response = "Classical music can be categorized into the Baroque, Classical, Romantic, and 20th century eras. May I recommend a piece to you?";
            lastNode = 'h';
            break;
         case 'i':
            response = "Would you like a sonata, concerto, or duet piece?";
            lastNode = 'i';
            break;
         case 'j':
            response = "Well, I will pick for you.";
            lastNode = 'j';
            break;
         case 'k':
            suggestPiece = true;
            response = nodeK(statement);
            lastNode  = 'k';
            break;
         case 'l':
            response = "What is your favorite piece?";
            lastNode = 'l';
            break;
         case 'm':
            response = "Thanks for sharing that.";
            lastNode  = 'm';
            break;
         case 'n':
            response = nodeN(statement);
            lastNode = 'n';
            break;
         case 'o':
            response = nodeO(statement);
            lastNode = 'o';
            break;
         case 'p':  
            response = "Can we talk about classical music?";
            lastNode = 'p';
            break;
         case 'q':
            response = "Tell me more.";
            lastNode = 'q';
            break;
         case 'r':
            response = "I like talking about music.";
            lastNode = 'r';
            break;
         case 's':
            response = "Let's talk about classical music.";
            lastNode = 's';
            break;
         case 't':
            response = "Do you have a favorite composer?";
            lastNode = 't';
            break;
         case 'u':
            response = "Who is your favorite composer?";
            lastNode = 'u';
            break;
         case 'v':
            response = "Can I help you find a new composer to listen to?";
            lastNode = 'v';
            break;
         case 'w':
            response = "Pretty please?";
            lastNode = 'w';
            break;
         case 'x':
            response = "I will ask you questions first. Do you like symphonies?";
            lastNode = 'x';
            break;
         case 'y':
            response = "Well too bad for you!";
            lastNode = 'y';
            break;
         case 'z':
            response = "I recommend Mahler! He has excellent symphonies.";
            lastNode = 'z';
            break;
         case '0':
            response = "Do you like ballets?";
            lastNode = '0';
            break;
         case '1':
            response = "I recommend Tchaikovsky! He composed music for the ballets Nutcracker, Swan Lake, and Sleeping Beauty.";
            lastNode = '1';
            break;
         case '2':
            response = "Do you like floating in ethereal dreamlands?";
            lastNode = '2';
            break; 
         case '3':
            response = "I recommend Debussy! He is known for his innovative instrumentation and use of harmony.";
            lastNode = '3';
            break;
         case '4':
            response = "What about compositions inspired by traditional music?";
            lastNode = '4';
            break;
         case '5':
            response = "I recommend Florence Price! She was the first African American woman to have her work performed by a major orchestra.";
            lastNode = '5';
            break;
         case '6':
            response = "Would you like music that tells a story";
            lastNode = '6';
            break;
         case '7':
            response = "I recommend Chen Gang and He Zhanhao! Specifically, their composition Butterfly Lovers.";
            lastNode = '7';
            break;
         case '8':
            response = "You are very picky! I do not like you. Let's try this again. ";
            lastNode = '8';
            break;
         case '9':
            response = "You are impossible. Listen to John Cage's 4\'33\"";
            lastNode = '9';
            break;
         case '!':
            response = "Do you like movies?";
            lastNode = '!'; 
            break;
         case '@':
            response = "Finally, something you like! I recommend Ralph Vaugh Williams. He's composed sountracks for many famous movies.";
            lastNode = '@';
            break;
         case '#':
            response = nodeHashtag(statement);
            lastNode = '#';
            break;
         case '$':
            response = babbling[babble];
            if(babble != 5){
               babble++;
            }
            else{
               babble = 0;
            }
            lastNode = '$';
      }
      return response;
	}
   
   //returns which node to go to next. 
   public char whereTo(String statement){
      
      //checks if in input based category
      if(inputBased.contains(lastNode)){
      
         //if it has useable input
         boolean validInvalid = findPhrase(statement.toLowerCase());
      
         //two branches, if the user cooperates or not
         switch(lastNode){
            case 'c':
               if(validInvalid){
                  return 'e';
               }
               else{
                  return 'd';
               }
            case 'e':
               if(validInvalid){
                  return 'g';
               }
               else{
                  return 'h';
               }
            case 'f':
               if(validInvalid){
                  return 'n';
               }
               else{
                  return 'p';
               }
            case 'i':
               if(validInvalid){
                  return 'k';
               }
               else{
                  return 'j';
               }
            case 'n':
               if(validInvalid){
                  return 'o';
               }
               else{
                  return 'q';
               }
            case 'u':
               if(validInvalid){
                  return '#';
               }
               else{
                  return 'v';
               }
         default:
            return 'y';
         }
      }
      
      //for booleans
      else if(yesnoBased.contains(lastNode)){
      
         //determine if the user says yes, if not assumes no
         boolean affirm = false;
         
         //checks if 'yes'
         if(affirmative.contains(statement.toLowerCase())){
            affirm = true;
         }
         
         //once again each case has two options
         switch(lastNode){
            case 'a':
               if(affirm){
                  return 'c';
               }
               else{
                  return 'b';
               }
            case 'b':
               if(affirm){
                  return 'd';
               }
               else{
                  return 'f';
               }
            case 'd':
               if(affirm){
                  return 'e';
               }
               else{
                  return 'f';
               }
            case 'g':
               if(affirm){
                  return 'i';
               }
               else{
                  return 'l';
               }
            case 'h':
               if(affirm){
                  return 'i';
               }
               else{
                  return 'r';
               }
            case 'p':
               if(affirm){
                  //prevent redundancy
                  if(!suggestPiece){
                  return 'h';
                  }
                  else{
                  return '$';
                  }
               }
               else{
                  return 'r';
               }
            case 't':
               if(affirm){
                  return 'u';
               }
               else if(findPhrase(statement)){
                  return '#';
               }
               else{
                  return 'v';
               }
            case 'v':
               if(affirm){
                  return 'x';
               }
               else{
                  return 'w';
               }
            case 'x':
               if(affirm){
                  return 'z';
               }
               else{
                  return '0';
               }
            case '#':
               if(affirm){
                  return 'x';
               }
               else{
                  return 'w';
               }
            case 'w':
               if(affirm){
                  return 'x';
               }
               else{
                  return 'y';
               }
            case '0':
               if(affirm){
                  return '1';
               }
               else{
                  return '2';
               }
            case '2':
               if(affirm){
                  return '3';
               }
               else{
                  return '4';
               }
            case '4':
               if(affirm){
                  return '5';
               }
               else{
                  return '6';
               }
            case '6':
               if(affirm){
                  return '7';
               }
               else{
                  return '8';
               }
            case '!':
               if(affirm){
                  return '@';
               }
               else{
                  return '9';
               }
            default:
               return 'y';  
            }      
      }
      
      //disregards whatever the user inputs next
      else if(automatic.contains(lastNode)){
         switch(lastNode){
            case 'j':
               return 'k';
            case 'k':
               return 't';
            case 'm':
               return 'r';
            case 'l':
               return 'm';
            case 'o':
            case 'q':
               return 'p';               
            case 'r':
               return 's';
            case 's':
               return 'h';
            case 'y':
               return 'x';
            case 'z':
            case '1':
            case '3':
            case '5':
            case '7':
            case '9':
            case '@':
               //prevent redundancy
               if(!askedGenre){
                  return 'f';
               }
               else{
               return '$';
               }
            case '8':
               return '!';
            default: 
               return 'y';
            }
      }
      else{
         return '$';
         }
      }
      
   //returns true if there is a viable input
   private boolean findPhrase(String statement1){
   
      //changes to lowercase
      String statement = statement1.toLowerCase();
      
      //scans through respective arrays/arraylists and sets strings to new values 
      switch(lastNode){
         case 'c':
            for(int i = 0; i < orchestra.length; i++){
               if(statement.contains(orchestra[i])){
                  orchFamily = i;
                  myInstrument = orchestra[i];
                  return true;
                  }
               }
               break;
         case 'e':
            for(int i = 0; i < eras.length; i++){
               if(statement.contains(eras[i])){
                  erasMatch = i;
                  yourEra = eras[i];
                  return true;
                  }
               } 
               break;
         case 'f':
            for(int i = 0; i < genres.length; i++){
               if(statement.contains(genres[i])){
                  yourGenre = genres[i];
                  return true;
                  }
               }
               break;
         case 'i':
            for(int i = 0; i < format.length; i++){
               if(statement.contains(format[i])){
                  formatMatch = i;
                  return true;
                  }
               }
               break;
         case 'n':
            for(int i = 0; i < feelings.length; i++){
               if(statement.contains(feelings[i])){
                  yourFeeling = feelings[i];
                  return true;
                  }
               }
               break;
         case 'u':
         case 't':
            for(int i = 0; i < composers.length; i++){
               if(statement.contains(composers[i].toLowerCase())){
                  yourComposer = composers[i];
                  return true;
                  }
               }
               break;
      }
      return false;
   }
   
   //fills in response with myInstrument and family
   private String nodeE(String statement){
      String family;
      if(myInstrument == " "){
         myInstrument = "violin";
         family = "string"; 
      }
      else{
         //matches which family of instruments
         if(orchFamily > -1 && orchFamily < 5){
            family = "string";
         }
         else if(orchFamily > 4 && orchFamily < 10){
            family = "woodwind";
         }
         else if(orchFamily > 9 && orchFamily < 14){
            family = "brass";
         }
         else{
            family = "percussion";
         }
      }
      String response = ("The " + myInstrument + " is a great instrument! I like instruments from the " 
      + family + " family. Do you have a favorite musical era?");
      return response;
   }
   
   //responds using yourEra and myDescription
   private String nodeG(String statement){
   
      //matches an era to a description
      String myDescription = eraDescription[erasMatch];
      String response = ("Excellent taste! The " + yourEra + " era is known for " + myDescription + 
      " May I recommend a " + yourEra + " piece to you?");
      return response;
   }
   
   //responds using myPiece and formatMatch 
   private String nodeK(String statement){
      String myPiece;
      if(formatMatch == 0){
         myPiece = sonatas[erasMatch];
      }
      else if(formatMatch == 1){
         myPiece = concertos[erasMatch];
      }
      else{
         myPiece = duets[erasMatch];
      }
      String response = ("I like listening to " + myPiece + ". I hope you will enjoy it!");
      return response;
   }
   
   //responds with yourGenre
   private String nodeN(String statement){
      String response = ("I do not know much about " + yourGenre +" music. How does " +
      yourGenre + " make you feel?");
      return response;
      
   }
   
   //responds with yourGenre and yourFeeling
   private String nodeO(String statement){
      String response = ("I did not know " + yourGenre + " music could make you feel " + yourFeeling + ".");
      return response;
   }
   
   //responds with yourComposer
   private String nodeHashtag(String statement){
      String response = ("I also love listening to " + yourComposer + "! Can I help you find a new composer to listen to?");
      return response;
   }
   
}
