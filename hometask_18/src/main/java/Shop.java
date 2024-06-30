import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class Shop {

    private Integer number;

    private String town;

    private String adress;

    private String phone;
}
