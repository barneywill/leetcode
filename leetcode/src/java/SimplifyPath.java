import java.util.ArrayList;
import java.util.List;

public class SimplifyPath {
    public static void main(String[] args) {
        SimplifyPath instance = new SimplifyPath();
        System.out.println(instance.simplifyPath("/home/"));
        System.out.println(instance.simplifyPath("/../"));
        System.out.println(instance.simplifyPath("/home//foo/"));
    }
    public String simplifyPath(String path) {
        StringBuffer result = new StringBuffer();
        List<String> paths = new ArrayList<String>();
        for (String str : path.split("/")) {
            if (str.equals("..")) {
                if (!paths.isEmpty()) {
                    paths.remove(paths.size() - 1);
                }
            } else if (!str.equals("") && !str.equals(".")) {
                paths.add(str);
            }
        }
        if (paths.isEmpty()) {
            result.append("/");
        } else {
            for (String p : paths) {
                result.append("/").append(p);
            }
        }
        return result.toString();
    }
}
