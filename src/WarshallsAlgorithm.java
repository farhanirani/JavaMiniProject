import java.util.Scanner;
class code
{
    int a[][] = new int[10][10];
    int row,col,num,count;
    public void getdata()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("****TRANSISTIVE CLOSURE USING WARSHALLS ALGORITHM****");
        System.out.println("THIS PROGRAM WILL FIND IF THERE IS A POSSIBLE PATH BETWEEN TWO PLACES");
        System.out.print("ENTER THE NUMBER OF PLACES:   ");
        count = s.nextInt();
        System.out.println("PLEASE INPUT 1:IF THERE IS A PATH");
        System.out.println("             0:IF THERE IS NO PATH, BETWEEN THE ASKED PLACES");
        for(row=0;row<count;row++)
        {
            for(col=0;col<count;col++)
            {
                do{
                    System.out.print("Is there a path between "+(row+1)+" and "+(col+1)+" ? : ");
                    a[row][col] = s.nextInt();
                }while(a[row][col]!=0&&a[row][col]!=1);
            }
        }
    }
    int cc,rc,i,j;
    int r[] = new int[10];
    int c[] = new int[10];
    
    public void calculate()
    {
        for(num=0;num<count;num++)
        {
            cc=0;
            rc=0;
            //to setting the column array
            for(row=0;row<count;row++)
            {
                if(a[row][num]==1)
                {
                    c[cc]=row;
                    cc++;
                }
            }
            //to set the row array
            for(col=0;col<count;col++)
            {
                if(a[num][col]==1)
                {
                    r[rc]=col;
                    rc++;
                }
            }
            //to combine col and rows, to set the values of the next matrix
            for(i=0;i<cc;i++)
            {
                for(j=0;j<rc;j++)
                {
                    a[c[i]][r[j]]=1;
                }
            }
        }
    }
    
    public void output()
    {
        System.out.println("THE FINAL TRANSISTIVE MATRIX IS: ");
        for(row=0;row<count;row++)
        {
            for(col=0;col<count;col++)
            {
                System.out.print("  "+a[row][col]);
            }
            System.out.println();
        }
        Scanner s = new Scanner(System.in);
        int p1,p2,exit=1;
        do{
            System.out.println("ENTER TWO PLACES TO CHECK IF THERE IS A PATH BETWEEN THEM.");
            System.out.print("PLACE 1: ");
            p1 = s.nextInt();
            System.out.print("PLACE 2: ");
            p2 = s.nextInt();
            if(a[p1-1][p2-1]==1)
                System.out.println("THERE IS A PATH BETWEEN "+p1+" and "+p2);
            else
                System.out.println("NO PATH BETWEEN "+p1+" and "+p2);
            
            System.out.print("TO CONTINUE, ENTER 1;  TO EXIT, ENTER 0:   ");
            exit = s.nextInt();
        }while(exit!=0);
    }
    
}

public class WarshallsAlgorithm {
    public static void main(String args[])
    {
            code x = new code();
            x.getdata();
            x.calculate();
            x.output();
            }
}