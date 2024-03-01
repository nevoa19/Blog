package Blog.infra.controllers.user.dtos.list;

import java.util.List;

public record UserDto(String id, String name, List<PostDto> posts) {



}
