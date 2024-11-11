public class Point3D extends Point2D {
    private float z = 0.0f;

    public Point3D() {
        super();
    }

    public Point3D(float z) {
        super();
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        this.z = z;
    }

    public float[] getXYZ() {
        float[] arr1 = super.getXY();
        float[] arr2 = new float[3];
        arr2[0] = arr1[0];
        arr2[1] = arr1[1];
        arr2[2] = this.z;
        return arr2;
    }

    @Override
    public String toString() {
        return "Point3D [x=" + getX() + ", y=" + getY() + ", z=" + z + "]";
    }
}

