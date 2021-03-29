import Input.*;
public class Test
{
    Gest_Input stdin=new Gest_Input();
    Stack texas=new Stack();
    Stack california=new Stack();
    Stack numbers=new Stack();//sposta giù
    String exp,polish;
    public void main()
    {
        int op=0;
        do
        {
            do
            {
                System.out.println("1)Inserimento espressione");
                System.out.println("2)Trasformazione in notazione polacca");
                System.out.println("3)Soluzione");
                System.out.println("4)Uscita");
                try
                {
                    op=Integer.valueOf(stdin.read());
                }catch(Exception E){}
            }while(op<1||op>4);
            switch(op)
            {
                case 1: insert();
                        break;
                case 2: polish();
                        break;
                case 3: System.out.println(polish);
                        resolve();
                        break;
            }
        }while(op!=4);
    }

    public void resolve()
    {
      
        char c;
        double op1=0,op2=0;
        for(int i=0;i<polish.length();i++)
        {
            c=polish.charAt(i);
            if(c>='0'&&c<='9')
                numbers.push((double)(c-'0'));
            else
            {
                op2=numbers.popN();
                op1=numbers.popN();
                switch(c)
                {
                    case '+':
                             numbers.push(op1+op2);
                             break;
                    case '-':
                             numbers.push(op1-op2);
                             break;
                    case '*':
                             numbers.push(op1*op2);
                             break;
                    case '/':
                             numbers.push(op1/op2);
                             break;
                }
            }
        }
        System.out.println("risultato: "+numbers.popN());
    }
    
    public void polish()
    {
        polish="";
        char c,p;
        for(int i=0;i<exp.length();i++)
        {
            c=exp.charAt(i);
            if(c>='0'&&c<='9')
                california.push(c);
            else
            {
                try
                {
                    p=texas.peek();
                }
                catch(Exception e)
                {
                    p=' ';
                }
                if(p==' ')
                    texas.push(c);
                else
                    switch(c)
                    {
                        case '+':
                        case '-':
                                 if(p!='(')
                                     california.push(texas.pop());
                                 texas.push(c);
                                 break;
                        case '*':
                        case '/':
                                 if(p=='*'||p=='/')
                                    california.push(texas.pop());
                                 else
                                     texas.push(c);
                                 break;
                        case '(':
                                 texas.push(c);
                                 break;
                        case ')':
                                 do
                                 {    
                                     p=texas.peek();
                                     if(p!='(')
                                         california.push(texas.pop());
                                     else
                                         texas.pop();
                                 }
                                 while(p!='(');
                                 break;
                        case '=':
                                 while(texas.ins>0)     
                                    california.push(texas.pop());
                                 break;
                    }
            }
        }
        int l=california.ins;
        String app="";
        for(int i=0;i<l;i++)
             app+=california.pop();
        for(int i=l-1;i>=0;i--)
             polish+=app.charAt(i);
        System.out.println("\n\n"+polish);
    }
    
    public void insert()
    {
        System.out.println("Inserire espressione: ('=' terminatore)");
        exp=stdin.read();
    }
}