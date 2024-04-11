public class ConvertService {

    private Double Course;

    public Double getCourse() {
        return Course;
    }

    public void setCourse(Double course) {
        Course = course;
    }

    public String convertToUsd(String str) {
//
//      ConvertFunctional convertFunctional = new ConvertFunctional() {
//          @Override
//          public String convert(String value) {
//
//                String[] s = value.split(" ");
//                int byn = Integer.parseInt(s[0]);
//                int convert = (int) (byn / Course);
//                return value.replace(value, String.format("%d USD", convert));
//            }
//        };
        return convert(str,
                (value) -> value.replace(value, String.format("%d USD", (int) (Integer.parseInt(value.split(" ")[0]) / Course))));

    }

    public String convert(String string, ConvertFunctional functional) {
        return functional.convert(string);
    }

}
