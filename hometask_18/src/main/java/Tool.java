import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data @AllArgsConstructor @NoArgsConstructor
public class Tool {

    private String name;

    private int price;

    private Category category;

    private boolean isDelivery;

    private List<Shop> shopList;

    private Producer producer;

}
