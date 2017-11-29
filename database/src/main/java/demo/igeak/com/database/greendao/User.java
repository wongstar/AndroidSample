package demo.igeak.com.database.greendao;

/**
 * Created by igeak on 2017/11/10.
 */


//@UserAnnotation(name = "Star",age = 10,person = @PersonAnnotation(say = "hello",move = "run",sex = Sex.MAN))

@UserAnnotation
public class User {
    @UserAnnotation(name = "Star")
    protected String name;

    @UserAnnotation(age = 100)
    int age;

    @UserAnnotation(name = "wong" , age = 1000)
    protected String value;

    @UserAnnotation(name = "GEAK",age = 90)
    public void getUserInfo(String name,int age){
        System.out.println("the name is:"+name+"\tthe age is:"+age);
    }

    public void getInfo(){
        System.out.println("=======getInfo start=====");
        System.out.println("the name is:"+this.name+"\tthe age is:"+this.age);
        System.out.println("=======getInfo end=====");
    }


}
