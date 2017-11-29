package demo.igeak.com.database.greendao;

/**
 * Created by igeak on 2017/11/16.
 */


@UserAnnotation(name = "wong",age = 80)
public class User2 {
    protected String name;
    int age;

    public void getUserInfo(){
        System.out.println("the name is:"+name+"\tthe age is:"+age);
    }

}
