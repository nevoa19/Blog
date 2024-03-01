package Blog.utils;

import Blog.domain.post.gateway.PostGateway;
import Blog.infra.repositories.post.memory.PostRepositoryMemory;

public class PostRepositoryUtils {

    private static final PostGateway postGateway = PostRepositoryMemory.create();

    public static PostGateway getPostGateway() {
        return postGateway;
    }
}
