package hw6;

public class Car {

    private boolean isWelded;
    private boolean isPainted;
    private boolean isCleaned;
    private int weldCount = 0;
    private int paintCount = 0;
    private int cleanCount = 0;

    @Override
    public String toString() {
        return("Welded: " + this.isWelded + "; Painted: " + this.isPainted + "; Cleaned: " + this.isCleaned);
    }

    public void incrementWeldCount(){
        weldCount++;
    }

    public void incrementPaintCount(){
        paintCount++;
    }

    public void incrementCleanCount(){
        cleanCount++;
    }


    public int getWeldCount() {
        return weldCount;
    }

    public void setWeldCount(int weldCount) {
        this.weldCount = weldCount;
    }

    public int getPaintCount() {
        return paintCount;
    }

    public void setPaintCount(int paintCount) {
        this.paintCount = paintCount;
    }

    public int getCleanCount() {
        return cleanCount;
    }

    public void setCleanCount(int cleanCount) {
        this.cleanCount = cleanCount;
    }

    public boolean isWelded() {
        return isWelded;
    }

    public void setWelded(boolean welded) {
        isWelded = welded;
    }

    public boolean isPainted() {
        return isPainted;
    }

    public void setPainted(boolean painted) {
        isPainted = painted;
    }

    public boolean isCleaned() {
        return isCleaned;
    }

    public void setCleaned(boolean cleaned) {
        isCleaned = cleaned;
    }
}
