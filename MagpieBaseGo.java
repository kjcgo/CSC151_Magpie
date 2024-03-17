//needed for ArrayLists
import java.util.ArrayList;
import java.util.List;
public class MagpieBaseGo{

   char lastNode = 'a';
   
   //What determines branching off
   List<Character> inputBased = new ArrayList<>(List.of('c', 'e', 'f', 'i', 'n'));
   List<Character> yesnoBased = new ArrayList<>(List.of('a', 'b', 'd', 'g', 'h', 'p'));
   List<Character> automatic = new ArrayList<>(List.of('j', 'k', 'l', 'm', 'o', 'q', 'r', 's'));

   
   //Instruments in orchestra
   //orchestra[0-4] string family (hah! string.)
   //orchestra[5-9] woodwind family
   //orchestra[10-13] brass family
   //orchestra[14-19] percussion family
   String[] orchestra = {"violin", "viola", "cello", "double bass",
   "harp", "flute", "piccolo", "oboe", "clarinet", "bassoon", 
   "trumpet", "french horn", "trombone", "tuba", 
   "piano", "timpani", "xylophone", "cymbals", "triangle", "snare drum"};
   int orchFamily = 0;
   
   //Eras of music
   String[] eras = {"baroque", "classical", "romantic", "20th century"};
   int erasMatch = 0;
   String[] eraDescription = {"its use of ornamentation, intricacy, and dramatic contrast.", 
   "its graceful and simple melodies as well as a focus on a clean and balanced sound.",
   "its passionate melodies, longer works, and emphasis on emotion and self expression.", 
   "innovative approaches to tone and instrumentation, and a divergence from tradition."};
   
   //type of piece
   String[] format = {"sonata", "concerto", "duet"};
   int formatMatch = 0;
   String[] sonatas = {"Bach Violin Sonata no 1 in G minor", "Mozart Violin Sonata no 17 in C major", 
   "Beethoven Kreutzer Sonata", "Ravel Violin Sonata No 2."};
   String[] concertos = {"Bach Violin Concerto no 1 in A minor", "Mozart Violin Concerto no 5", 
   "Bruch Violin Concerto in G minor", "Shostakovich Violin Concerto no 1 in A minor"};
   String[] duets = {"Bach Double Violin Concerto in D minor",  "Mozart Duo for Violin and Viola in G Major", 
   "Passacaglia for Violin and Viola by Halvorsen", "Strauss Duet Concertino for Clarinet and Bassoon"};
   
   //other genres
   String[] genres = {"jazz", "kpop","pop", "rock", "country", "blues", "electronic", "funk", "indie"};
   //remember genre if needed
   String yourGenre = " ";
   //emotions
   String[] feelings = {"happy", "nostagic", "sad", "energetic", "calm"};
 
   //Various ways of saying yes
   //List<Character> yesnoBased = new ArrayList<>(List.of('a', 'b', 'd', 'g', 'h', 'p'));
   List<String> affirmative = new ArrayList<>(List.of("yes", "sure", "alright", "okay", "ok", "yeah"));
	public String getGreeting(){
   
		//Create your own greeting
      return("Hello, I am Maggie! Do you like classical music?");
	}
	
	public String getResponse(String statement)
	{
   
      char nextNode = whereTo(statement.toLowerCase());
      String response = "ERROR!";
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
            response = "Well, what music do you like?";
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
            response = nodeK(statement);
            lastNode  = 'k';
            break;
         case 'l':
            response = "What is your favorite piece?";
            lastNode = 'l';
            break;
         case 'm':
            response = "I will give that a listen, thanks!";
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
      }
      return response;
	}
   //returns which node to go to next. 
   public char whereTo(String statement){
      
      //for input based nodes
      //Arrays.asList(inputBased).contains(lastNode)
      if(inputBased.contains(lastNode)){
      
         //Determines if valid or not
         String myPhrase = findPhrase(statement.toLowerCase());
         
         boolean validInvalid = false;
         //determine if valid or not
         if(myPhrase != "none"){
            validInvalid = true;
         }
         //return where the next target is
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
         default:
            return 'y';
         }
      }
      //for boolean nodes
      //Arrays.asList(yesnoBased).contains(lastNode)
      else if(yesnoBased.contains(lastNode)){
         //determine if the user says yes, if not assume no
         //boolean affirm = findKeyword(statement, affirmative);
         boolean affirm = false;
         
         if(affirmative.contains(statement)){
            affirm = true;
         }
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
                  return 'h';
               }
               else{
                  return 'r';
               }
            default:
               return 'y';  
            }      
      }
      else if(automatic.contains(lastNode)){
         switch(lastNode){
            case 'j':
               return 'k';
            case 'k':
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
            default: 
               return 'y';
            }
      }
      else{
         return 'y';
         }
      }
   //returns sections of the statement
   private String findPhrase(String statement1){
      String statement = statement1.toLowerCase();
      switch(lastNode){
         case 'c':
            for(int i = 0; i < orchestra.length; i++){
               if(statement.contains(orchestra[i])){
                  orchFamily = i;
                  return orchestra[i];
                  }
               }
         case 'e':
            for(int i = 0; i < eras.length; i++){
               if(statement.contains(eras[i])){
                  erasMatch = i;
                  return eras[i];
                  }
               }
         case 'f':
            for(int i = 0; i < genres.length; i++){
               if(statement.contains(genres[i])){
                  return genres[i];
                  }
               }
         case 'i':
            for(int i = 0; i < format.length; i++){
               if(statement.contains(format[i])){
                  formatMatch = i;
                  return format[i];
                  }
               }
         case 'n':
            for(int i = 0; i < feelings.length; i++){
               if(statement.contains(feelings[i])){
                  return feelings[i];
                  }
               }
        default:
            return "none";
      
      
      }
   }
   private String nodeE(String statement){
      String family;
      String myInstrument = findPhrase(statement);
      if(myInstrument == "none"){
         myInstrument = "violin";
         family = "string"; 
      }
      else{
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
   
   private String nodeG(String statement){
     
      String myEra = findPhrase(statement);
      String myDescription = eraDescription[erasMatch];
      String response = ("Excellent taste! The " + myEra + " era is known for " + myDescription + 
      " May I recommend a " + myEra + " piece to you?");
      return response;
   }
   
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
   
   private String nodeN(String statement){
      yourGenre = findPhrase(statement);
      String response = ("I do not know much about " + yourGenre +" music. How does " +
      yourGenre + " make you feel?");
      return response;
      
   }
 
   private String nodeO(String statement){
      String yourFeeling = findPhrase(statement);
      String response = ("I did not know " + yourGenre + " music could make you feel " + yourFeeling + ".");
      return response;
   }
   
}
