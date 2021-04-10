package test.proxy;

public class userDao implements IuserDao{

    @Override
    public void save() {
        System.out.println(
                "保存数据"
        );
    }
}
