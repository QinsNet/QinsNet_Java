package mt.client;

import com.qins.net.meta.annotation.field.Field;
import com.qins.net.meta.annotation.instance.Meta;
import com.qins.net.node.annotation.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Meta(value = "Package",nodes = "User")
public abstract class Package {
    @Field
    String name;
    @Post
    public boolean pack(){
        if(name != null){
            System.out.println(name + " Pack!!!");
            return true;
        }
        return false;
    }
}
