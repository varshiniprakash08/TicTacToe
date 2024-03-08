package player;

public class Player {
private String name, email,add;
private String num;
private char symb;
private int age;

public void set_details(String n, String e, String a, String nu, char s, int ag)
{
    name=n;
    email=e;
    add=a;
    num=nu;
    symb=s;
    age=ag;

}
public void get_details()
{
    System.out.println("Name: "+this.name);
    System.out.println("Age: "+this.age);
    System.out.println("Symbol: "+this.symb);
    System.out.println("Email: "+this.email);
    System.out.println("Phone: "+this.num);
    System.out.println("Address: "+this.add);
}
public String get_name()
{
    return this.name;
}
public char get_symbol()
{
    return this.symb;
}
}
