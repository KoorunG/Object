package calculatescore;

public class Grade {

    private String name;
    private int upper, lower;

    protected Grade(String name, int upper, int lower){
        this.name = name;
        this.upper = upper;
        this.lower = lower;
    }

    public String getName(){
        return name;
    }

    public boolean isName(String name){
        return this.name.equals(name);
    }

    public boolean include(int score){          // 성적이 해당 등급에 포함하는지 여부를 검사
        return score >= lower && score <= upper;
    }

}
