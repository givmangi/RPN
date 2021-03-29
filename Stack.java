public class Stack
{
    element top,bottom,curr;
    int ins=0;
    
    public double popN()
    {
        double r=0.0;
        if(top!=null)
        {
            r=top.num;
            top=top.prev;
            ins--;
        }
        else
            System.out.println("stack vuoto");
        return r;
    }
    
    public char pop()
    {
        char r=' ';
        if(top!=null)
        {
            r=top.cont;
            top=top.prev;
            ins--;
        }
        else
            System.out.println("stack vuoto");
        return r;
    }
    
    public void push(char n)
    {
        element temp=new element(n);
        if(bottom==null)
        {
            bottom=temp;
            top=temp;
        }
        else 
        {
            temp.prev=top;
            top=temp;
        }
        ins++;
    }
    
    public void push(double n)
    {
        element temp=new element(n);
        if(bottom==null)
        {
            bottom=temp;
            top=temp;
        }
        else 
        {
            temp.prev=top;
            top=temp;
        }
        ins++;
    }
    
    public char peek()
    {
        return top.cont;
    }
}