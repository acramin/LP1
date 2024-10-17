package Ex3;

public class Aluno
{
    // A class that represents one record of information.
    private String nome;
    private String sobrenome;
    private String ra;
    private double p1;
    private double p2;
    private double p3;
    private double p4;
    private double media;

    public Aluno() {
        this("", "", "", 0, 0, 0, 0);
    }
    
    // initialize a record
    public Aluno( String ra, String first, String last, double p1, double p2, double p3, double p4 )
    {
        setra( ra );
        setnome( first );
        setsobrenome( last );
        setp1( p1 );
        setp2( p2 );
        setp3( p3 );
        setp4( p4 );
        this.media = getMedia();
    } // end seven-argument AccountRecord constructor

    public void setnome( String first ) // set first name
    {
        nome = first;
    } // end method setnome

    public String getnome() // get first name
    {
        return nome;
    } // end method getnome

    public void setsobrenome( String last ) // set last name
    {
        sobrenome = last;
    } // end method setsobrenome

    public String getsobrenome() // get last name
    {
        return sobrenome;
    } // end method getsobrenome

    public void setra( String rA ) // set account number
    {
        ra = rA;
    } // end method setra

    public String getra() // get account number
    {
        return ra;
    } // end method getra

    public void setp1( double p1 ) // set balance
    {
        this.p1 = p1;
    } // end method setp1

    public double getp1() // get balance
    {
        return p1;
    } // end method getp1

    public void setp2( double p2 ) // set balance
    {
        this.p2 = p2;
    } // end method setp2

    public double getp2() // get balance
    {
        return p2;
    } // end method getp2

    public void setp3( double p3 ) // set balance
    {
        this.p3 = p3;
    } // end method setp3

    public double getp3() // get balance
    {
        return p3;
    } // end method getp3

    public void setp4( double p4 ) // set balance
    {
        this.p4 = p4;
    } // end method setp4

    public double getp4() // get balance
    {
        return p4;
    } // end method getp4

    public double getMedia() {
        return (p1 + p2 + p3 + p4) / 4;
    }

    
} // end class AccountRecord

