package Ex1;

public class User
{
    // A class that represents one record of information.
    private String user;
    private String password;

    // no-argument constructor calls other constructor with default values
    public User()
    {
        this(  "", ""); // call four-argument constructor
    } // end no-argument AccountRecord constructor

    // initialize a record
    public User( String first, String last )
    {
        setuser( first );
        setpassword( last );

    } // end four-argument AccountRecord constructor

    public void setuser( String first ) // set first name
    {
        user = first;
    } // end method setuser

    public String getuser() // get first name
    {
        return user;
    } // end method getuser

    public void setpassword( String last ) // set last name
    {
        password = last;
    } // end method setpassword

    public String getpassword() // get last name
    {
        return password;
    } // end method getpassword
} // end class AccountRecord

