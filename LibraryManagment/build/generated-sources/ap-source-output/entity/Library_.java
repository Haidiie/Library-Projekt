package entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-09-25T21:32:19")
@StaticMetamodel(Library.class)
public class Library_ { 

    public static volatile SingularAttribute<Library, String> author;
    public static volatile SingularAttribute<Library, String> name;
    public static volatile SingularAttribute<Library, String> genre;
    public static volatile SingularAttribute<Library, Integer> id;
    public static volatile SingularAttribute<Library, Integer> published;

}