package exceptions;

class DynamicFieldsException extends Exception{}

public class DynamicFields {

    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for(int i = 0; i < initialSize; i++) {
            fields[i] = new Object[] {null, null};
        }
    }

    @Override public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id){
        for(int i = 0; i < fields.length; i++) {
            if(id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldIndex(String id)
            throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if(fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for(int i = 0; i < fields.length; i++) {
            if(fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        Object[][] tmp = new Object[fields.length + 1][2];
        for(int i = 0; i < fields.length; i++) {
            tmp[i] = fields[i];
        }
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[] {null, null};
        }
        fields = tmp;
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldIndex(id)][1];
    }

    public Object setField(String id, Object value)
            throws DynamicFieldsException{
        if(value == null) {
            DynamicFieldsException dfe = new DynamicFieldsException();
            throw dfe;
        }
        int fieldNum = hasField(id);
        if(fieldNum == -1) {
            fieldNum = makeField(id);
        }
        Object result = null;
        try{
            result = getField(id);
        }catch(NoSuchFieldException e){
            throw new RuntimeException(e);
        }
        fields[fieldNum][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);
        try{
            df.setField("d", "A value of");
            df.setField("number", 47);
            df.setField("number_2", 48);
            System.out.println(df);
            df.setField("number_3", 11);
            System.out.println("df: " + df);
            System.out.println("df.getField(\"d\") = " + df.getField("d"));
            Object field = df.setField("d", null);
        } catch (NoSuchFieldException | DynamicFieldsException e){
            e.printStackTrace(System.out);
        }
    }
}

