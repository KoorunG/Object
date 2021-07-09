package shape;

public class Rectangle {
    private int left;
    private int top;
    private int right;
    private int bottom;

    public Rectangle(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
    }


    public void enlarge(int multiple){
        right *= multiple;
        bottom*= multiple;
    }                                   // 너비와 높이를 조절하는 로직 구현
                                        // Rectangle을 변경하는 주체를 외부 객체 -> 자기 자신으로 이동 
                                        // 객체가 자기 스스로 책임을 진다는 의미! (캡슐화)

}

// class Anyclass {
//     void AnyMethod(Rectangle rectangle, int multiple){
//         rectangle.setRight(rectangle.getRight()*multiple);
//         rectangle.setBottom(rectangle.getBottom()*multiple);
//     }
// }                                    // 1. 코드 중복이 발생할 확률이 높음
                                        // 2. 변경에 취약함 (캡슐화가 미약함) -> Rectangle을 변경하는 로직은 그 안에 집어넣는게 좋다
