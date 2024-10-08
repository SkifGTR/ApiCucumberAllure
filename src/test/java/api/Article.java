
package api;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class Article {
    private List<Object> categories;
    private String content;
    private String lang;
    private String layout;
    private List<Object> tags;
    private String title;
    private String url;
}
