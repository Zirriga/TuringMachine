package turingmachine;

import java.util.List;

public class MemoryBuffer {
    public String C0;
    public String C1;
    public String C2;
    public String C3;
    public String C4;
    public String C5;
    public String C6;
    public String C7;
    public String C8;
    public String C9;
    public String C10;

    public MemoryBuffer() {
        this.C0 = "_";
        this.C1 = "_";
        this.C2 = "_";
        this.C3 = "_";
        this.C4 = "_";
        this.C5 = "_";
        this.C6 = "_";
        this.C7 = "_";
        this.C8 = "_";
        this.C9 = "_";
        this.C10 = "_";
    }

    public MemoryBuffer(List<String> input) {
        this.C0 = input.get(0);
        this.C1 = input.get(1);
        this.C2 = input.get(2);
        this.C3 = input.get(3);
        this.C4 = input.get(4);
        this.C5 = input.get(5);
        this.C6 = input.get(6);
        this.C7 = input.get(7);
        this.C8 = input.get(8);
        this.C9 = input.get(9);
        this.C10 = input.get(10);
    }
}
