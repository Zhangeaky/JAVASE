package top.zhangeaky.entity;

public class player {

    public player(String name, String team, Integer number) {
        this.name = name;
        Team = team;
        this.number = number;
    }
    player(){}

    private String name;
    private String Team;
    private Integer number;

    void shot(){
        System.out.println("shot!!!");
    }
    void pass(){
        System.out.println("pass!!!");
    }

    static {


        System.out.println("player loadding");
    }
}
