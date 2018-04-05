package generic;

/**
 * 有界通配符?
 * Created by zfz on 2017/12/9.
 */
public class GenericLearn08 {

    public static void main(String[] args) {
        TwoD[] twoDS = new TwoD[]{
                new TwoD(10, 20),
                new TwoD(10, 21),
                new TwoD(10, 22)
        };

        ThreeD[] threeDS = new ThreeD[]{
                new ThreeD(10, 20, 2),
                new ThreeD(10, 21, 2),
                new ThreeD(10, 22, 2)
        };

        FourD[] fourDS = new FourD[]{
                new FourD(10, 2, 2, 1),
                new FourD(10, 2, 2, 2),
                new FourD(10, 2, 2, 3)
        };
        BoundWildCard.showXY(new Coordinates<>(twoDS));
        BoundWildCard.showXY(new Coordinates<>(threeDS));

        //有了通配符上界 <? extends ThreeD>则TwoD不能传给ShowXYZ作为参数
        //BoundWildCard.showXYZ(new Coordinates<>(twoDS));
        BoundWildCard.showXYZ(new Coordinates<>(threeDS));
        BoundWildCard.showXYZ(new Coordinates<>(fourDS));

        //BoundWildCard.showXYZT(new Coordinates<>(threeDS));
        BoundWildCard.showXYZT(new Coordinates<>(fourDS));

    }

    static class BoundWildCard {

        public static void showXY(Coordinates<?> c) {
            System.out.println("X Y coordinates ");
            for (int index = 0; index < c.coordinates.length; index++) {
                int x = c.coordinates[index].getX();
                int y = c.coordinates[index].getY();
                System.out.println("x " + x + " y " + y);
            }
        }

        public static void showXYZ(Coordinates<ThreeD> c) {
        //public static void showXYZ(Coordinates<? extends ThreeD> c) {
            System.out.println("X Y Z coordinates ");
            for (int index = 0; index < c.coordinates.length; index++) {
                int x = c.coordinates[index].getX();
                int y = c.coordinates[index].getY();
                int z = c.coordinates[index].getZ();
                System.out.println("x " + x + " y " + y + " z " + z);
            }
        }

        public static void showXYZT(Coordinates<? extends FourD> c) {
            System.out.println("X Y Z T coordinates ");
            for (int index = 0; index < c.coordinates.length; index++) {
                int x = c.coordinates[index].getX();
                int y = c.coordinates[index].getY();
                int z = c.coordinates[index].getZ();
                int t = c.coordinates[index].getT();
                System.out.println("x " + x + " y " + y + " z " + z + " t " + t);
            }
        }

    }

    static class Coordinates<T extends TwoD> {
        public T[] coordinates;

        public Coordinates(T[] coordinates) {
            this.coordinates = coordinates;
        }
    }


    static class TwoD {
        private int x;
        private int y;

        public TwoD(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    static class ThreeD extends TwoD {
        private int z;

        public ThreeD(int x, int y, int z) {
            super(x, y);
            this.z = z;
        }

        public int getZ() {
            return z;
        }

        public void setZ(int z) {
            this.z = z;
        }
    }

    static class FourD extends ThreeD {
        private int t;

        public FourD(int x, int y, int z, int t) {
            super(x, y, z);
            this.t = t;
        }

        public int getT() {
            return t;
        }

        public void setT(int t) {
            this.t = t;
        }
    }
}
