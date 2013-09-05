package asignment6;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.EmptyStackException;
import java.util.Stack;

public class ExpressionEvaluation {

	private String exp;
	
	public ExpressionEvaluation() {
		// TODO Auto-generated constructor stub
	}

	public ExpressionEvaluation(String expresion) {
		// TODO Auto-generated constructor stub
		
		exp = expresion;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		BufferedReader bb = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter a string to evaluate");;
		String s = bb.readLine();
		
		ExpressionEvaluation e = new ExpressionEvaluation(s);
		
		if(e.balanced(s)){
			String p = e.toPostFixString(s);
			
			System.out.println("Post fix is: "+p);
			
			double d = e.evaluatePostfix(p);
			System.out.println("Outout is : "+d);
			
		}
		
	}
	
	boolean balanced(String s){
		Stack<Character> st = new Stack<Character>();
		char ch,c;

		for(int i = 0;  i < s.length(); i++){
			ch = s.charAt(i);
			
			if(ch == '('){
				st.push('(');
			}
			else if(ch== '{'){

				st.push('{');

			}else if(ch == '['){

				st.push(')');

			}

			if(ch == ')' || ch == '}' || ch == ']'){
				if(st.isEmpty()){
					return false;
				}

				if(ch == ')'){
					c = st.peek();

					if(c == '('){
						st.pop();
					}
					else{
						return false;
					}
				}
				else if(ch == '}'){
					c = st.peek();

					if(c == '{'){
						st.pop();
					}
					else{
						return false;
					}
				}
				else if(ch == ']'){
					c = st.peek();

					if(c == '['){
						st.pop();
					}
					else{
						return false;
					}
				}

			}

		}

		if(st.isEmpty()){
			return true;
		}

		return false;
	}
	
	public boolean isOperator(char ch){
		return false;
		
	}
	
	public String toPostFixString(String s){
		
		Stack<Character> st = new Stack<Character>();
		
		StringBuffer sb = new StringBuffer();
		char ch;

		for(int i = 0; i < s.length(); i++){
			ch = s.charAt(i);
			
			if(Character.isLetter(ch) || Character.isDigit(ch))
				sb.append(ch);
			else{
				if(st.isEmpty() || ch == '(' || precedence(ch) >= precedence(st.peek()) || ch == '^'){
					st.push(ch);
				}
				else if(ch == ')'){
					char chc;
					try{
						while((chc = st.pop()) != '('){
							if(ch != '(')
								sb.append(chc);
						}
					}catch(EmptyStackException e){

					}
					
				}
				else{
					while(!st.isEmpty() && precedence(ch) < precedence(st.peek())){
						sb.append(st.pop());
					}

					st.push(ch);
				}
			}

		}
		
		while(!st.isEmpty()){
			sb.append(st.pop());
		}

		
		return sb.toString();

	}
	
	int precedence(char ch){
		switch(ch){
		case '^':
		case '$':
			return 4;
		case '*':
		case '/':
		case '%':
			return 3;
		case '+':
		case '-':
			return 2;
		case '(':
		case ')':
			return 1;
		}

		return 0;
	}

	
	double evaluatePostfix(String s){
		int b,c;
		char ch;
		
		Stack<Integer> st = new Stack<Integer>();

		for(int i = 0; i < s.length(); i++){
			ch = s.charAt(i);

			if(ch >= '0' && ch<= '9'){
				st.push(ch-48);
			}
			
			else if(ch == '*'){
				c = st.pop();
				b = st.pop();
				st.push(b*c);
			}
			else if(ch == '+'){
				c = st.pop();
				b = st.pop();
				st.push(b+c);
			}
			else if(ch == '-'){
				c = st.pop();
				b = st.pop();
				st.push(b-c);
			}
			else if(ch == '/'){
				c = st.pop();
				b = st.pop();
				st.push(b/c);
			}
			else if(ch == '%'){
				c = st.pop();
				b = st.pop();
				st.push(b%c);
			}

		}
		
		return st.pop();

	}
	
	double evaluatePostfixRadix(String s){
		int b,c,x = 0, f = 0;
		char ch;
		
		Stack<Integer> st = new Stack<Integer>();

		for(int i = 0; i < s.length(); i++){
			ch = s.charAt(i);

			if(ch >= '0' && ch<= '9'){
				f = 1;
				x = x*10 + (ch-48);
			}
			else if(ch == '#'){
				if(f != 0){
					f = 0;
					st.push(x);
					x = 0;
				}
			}
			else if(ch == '*'){
				c = st.pop();
				b = st.pop();
				st.push(b*c);
			}
			else if(ch == '+'){
				c = st.pop();
				b = st.pop();
				st.push(b+c);
			}
			else if(ch == '-'){
				c = st.pop();
				b = st.pop();
				st.push(b-c);
			}
			else if(ch == '/'){
				c = st.pop();
				b = st.pop();
				st.push(b/c);
			}
			else if(ch == '%'){
				c = st.pop();
				b = st.pop();
				st.push(b%c);
			}

		}
		
		return st.pop();

	}
	

}
