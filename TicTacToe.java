import java.util.Scanner;

class Grid                                  //class Grid 
{	
	char[] state = {'.','.','.','.','.','.','.','.','.','.'};
	public void input(char no,char symbol)         //Function to take input and update the grid           
	{	
		int pos;
		do
		{
			System.out.printf("\nPlayer %c: Enter the location (from 1 to 9) where you want to place %c: ",no,symbol);
			Scanner sc = new Scanner(System.in);
			pos = sc.nextInt();
			if(state[pos]!='.')
				System.out.printf("Already Filler Select other place\n");
		}while(state[pos]!='.');
		state[pos] = symbol;
	}	
	
	public boolean check(char symbol, char c[])    //Function to check if someone has won
	{	
		if(c[1]==c[2] && c[2]==c[3] && c[1]==symbol)
			return true;
		else if(c[4]==c[5] && c[5]==c[6] && c[4]==symbol)
			return true;
		else if(c[7]==c[8] && c[8]==c[9] && c[7]==symbol)
			return true;
		else if(c[1]==c[4] && c[4]==c[7] && c[1]==symbol)
			return true;
		else if(c[2]==c[5] && c[5]==c[8] && c[2]==symbol)
			return true;
		else if(c[3]==c[6] && c[6]==c[9] && c[3]==symbol)
			return true;
		else if(c[1]==c[5] && c[5]==c[9] && c[1]==symbol)
			return true;
		else if(c[3]==c[5] && c[5]==c[7] && c[3]==symbol)
			return true;
		else 
			return false;
	}
	
	public boolean left(char c[])          //Function to check if the grid is completely filled
	{
		for(int i=1;i<=9;i++)
			if(c[i]=='.')
				return true;
		return false;
	}
	
	public void printi(char c[])                 //Function to print the grid
	{
		System.out.printf("  ___ ___ ___\n |   |   |   |                1 | 2 | 3\n");
		System.out.printf(" | %c | %c | %c |               ---|---|---",c[1],c[2],c[3]);
		System.out.printf("\n |___|___|___|                4 | 5 | 6\n |   |   |   |               ---|---|---\n");
		System.out.printf(" | %c | %c | %c |                7 | 8 | 9 ",c[4],c[5],c[6]);
		System.out.printf("\n |___|___|___|\n |   |   |   |\n");
		System.out.printf(" | %c | %c | %c |",c[7],c[8],c[9]);
		System.out.printf("\n |___|___|___|\n");
	}
}

class Computer extends Grid                  //Class computer derived from Grid. Has addition computer AI functions
{
	int evaluate(char c[])              //Tells whether the player or comp is winning at a given future condition
	{
		if(check('X',c)==true) 
			return 10;
		else if(check('O',c)==true) 
			return -10;
		else 
			return 0;
	}

	int minimax(char c[], boolean turn)   //Fills the grid one by one and then selects the best move that 
	{                                     //ensures the worst outcome for the opponent
    	int point = evaluate(c);
    	if(point==10 || point==-10)
		return point; 
    	if(left(c)==false) 
    		return 0;	
 	if(turn)
    	{
        	int top = -1000;
        	for(int i=1;i<=9;i++)
        	{
                if (c[i]=='.')
                {
                    c[i] = 'X';
                    top = Math.max(top, minimax(c, !turn));
                    c[i] = '.';
                }
            } return top;
        }
    	else
    	{
    	    int top = 1000;
        	for(int i=1;i<=9;i++)
        	{
                if (c[i]=='.')
                {
                    c[i] = 'O';
                    top = Math.min(top, minimax(c, !turn));
                    c[i] ='.';
                }
            } return top;
      	}
	}
	
	int bestmove()                               //Funtion to find the optimal position based on minimax algorithm
	{
		int best=1000, move, reply=0;
		for(int i=1;i<=9;i++)
		{
			if(state[i]=='.')
			{
				state[i]='O';
				move=minimax(state,true);
				state[i]='.';
				if(move<best)
				{
					best=move;
					reply=i;
				}
			}
		}
		state[reply]='O';
		return reply;
	}
}

public class TicTacToe                                 //Main class TicTacToe
{
	public static void main(String[] args) 
	{
		char ans;
		char p;
		char[] n = {'0','1','2','3','4','5','6','7','8','9'};
		do
		{
			char p1, p2;
			int i, choice, count=0;
			Computer comp = new Computer();
			Grid g = new Grid();
			System.out.print("\033[H\033[2J");
			Scanner sc = new Scanner(System.in);
			System.out.printf("WELCOME\nFor computer press 1, for multiplayer press 2: ");
			choice=sc.nextInt();
			if(choice==1)            //Choice of game modes
			{
				p1='X';
				p2='O';
				System.out.printf("Player you are X\n");
				comp.printi(comp.state);
				System.out.printf("\nThis is the game grid.\nTo put your symbol on the grid, enter the no corresponding to the location where you want to play.\n\nSTART\n");
				System.out.printf("\nX gets to play first");
				i=2;
				do               //alternate turns for player and computer 
				{
					int loc;
					i++;
					i=2-(i%2);
					if(i==1)
					{
						comp.input('\0','X');
						comp.printi(comp.state);
					}
					else
					{
						loc = comp.bestmove();
						comp.printi(comp.state);
						System.out.printf("\nComputer chose loaction %d\n",loc);
					}
					count++;
				}while(comp.check('X',comp.state)==false && comp.check('O',comp.state)==false && count<9);
				//checks if game ended or not
				if(comp.check('X',comp.state)==true)
					System.out.printf("\nPlayer wins!!");
				else if(comp.check('O',comp.state)==true)	
					System.out.printf("Computer wins!!\n");
				else
					System.out.printf("\nIt's a DRAW!!\n");	
			}
			else if(choice==2)       //Multiplayer game mode
			{
				System.out.printf("\nPlayer 1 Enter your choice X or O: ");
				p1 = sc.next().charAt(0);
				if(p1=='X')
					p2 = 'O';
				else
					p2 = 'X';
				System.out.printf("Player 2 you are: %c\n",p2);
				g.printi(g.state);
				System.out.printf("\nThis is the game grid.\nTo put your symbol on the grid, enter the no corresponding to the location where you want to play.\n\nSTART\n");
				if(p1=='X')
					i = 2;
				else
					i = 1;
				System.out.printf("\nX gets to play first");
				do                  //Alternating turns to both players
				{				
					i++;
					i=2-(i%2);
					if(i==1)
						p=p1;
					else
						p=p2;
					boolean result;
					g.input((char)(i+48),p);
					g.printi(g.state);
					result=g.check(p,g.state);
					count++;
				}while(g.check(p,g.state)==false && count<9);
				if(g.check(p,g.state)==false)
					System.out.printf("\nIt's a DRAW!!\n");
				else
					System.out.printf("\nPlayer %d wins!!\n",i);
			}
			System.out.printf("Thanks for playing. To play again press(y), to exit press(n) - ");
			Scanner sc1=new Scanner(System.in);
			ans=sc1.next().charAt(0);	
		}while(ans=='y' || ans=='Y');       //asking to exit or continue
	}
}
