package reverse;

import java.util.*;
import com.google.common.collect.*;


public class ReversePhrase{

    private List<String> testCaseOutput = new ArrayList<String>();
    private Stack<String> forReversing = new Stack<String>();

	public void reverse(String[] phrases){

        for(int i=0; i < phrases.length; i++){
            System.out.println("phrase : " + phrases[i]);
            StringTokenizer stringTokens = new StringTokenizer(phrases[i]);
            while (stringTokens.hasMoreTokens()) {
                forReversing.push(stringTokens.nextToken());               
            }

            StringBuilder reversedPhrase = new StringBuilder();
            while (!forReversing.empty()){
                reversedPhrase.append(forReversing.pop() + " ");
            }
            testCaseOutput.add(reversedPhrase.toString());
        }       

    }

    public List<String> getTestCaseOutput(){
        return testCaseOutput;
    }

}