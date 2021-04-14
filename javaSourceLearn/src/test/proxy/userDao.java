package test.proxy;
class father{

}
public class userDao extends father implements IuserDao{
    void say(){
        System.out.println("say...");
    }

    void flag(){

        System.out.println("hello!");
    }

    void sleep(){

        System.out.println("ZZZZ...");

    }
    @Override
    public void save() {
        System.out.println(
                "保存数据"
        );
    }
}
