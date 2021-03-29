import Input.*;
public class element
{    
    char cont;
    double num;
    element prev;
    element(char n)
    {
        cont=n;
        prev=null;
    }
    element(double n)
    {
        num=n;
        prev=null;
    }
}    
