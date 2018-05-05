// **********************************************************************
//
// Copyright (c) 2003-2018 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.7.1
//
// <auto-generated>
//
// Generated from file `bank.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package bank.gen.ice.Bank;

public class Person implements java.lang.Cloneable,
                               java.io.Serializable
{
    public String name;

    public String surname;

    public String pesel;

    public Person()
    {
        this.name = "";
        this.surname = "";
        this.pesel = "";
    }

    public Person(String name, String surname, String pesel)
    {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
    }

    public boolean equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        Person r = null;
        if(rhs instanceof Person)
        {
            r = (Person)rhs;
        }

        if(r != null)
        {
            if(this.name != r.name)
            {
                if(this.name == null || r.name == null || !this.name.equals(r.name))
                {
                    return false;
                }
            }
            if(this.surname != r.surname)
            {
                if(this.surname == null || r.surname == null || !this.surname.equals(r.surname))
                {
                    return false;
                }
            }
            if(this.pesel != r.pesel)
            {
                if(this.pesel == null || r.pesel == null || !this.pesel.equals(r.pesel))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Bank::Person");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, name);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, surname);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, pesel);
        return h_;
    }

    public Person clone()
    {
        Person c = null;
        try
        {
            c = (Person)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeString(this.name);
        ostr.writeString(this.surname);
        ostr.writeString(this.pesel);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.name = istr.readString();
        this.surname = istr.readString();
        this.pesel = istr.readString();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, Person v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public Person ice_read(com.zeroc.Ice.InputStream istr)
    {
        Person v = new Person();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Person> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, Person v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<Person> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(Person.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final Person _nullMarshalValue = new Person();

    public static final long serialVersionUID = 4691543092309931492L;
}