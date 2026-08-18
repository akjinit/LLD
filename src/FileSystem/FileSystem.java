package FileSystem;

public class FileSystem {
    private FileSystemNode root;

    public FileSystem() {
        this.root = new Directory("/");
    }

    public boolean isValidFilePath(String path) {
        return path != null && path.startsWith("/");
    }

    public boolean createPath(String path) {
        if (!isValidFilePath(path)) return false;

        String[] pathComponents = path.split("/");
        FileSystemNode current = root;

        for (int i = 1; i < pathComponents.length - 1; i++) {
            String component = pathComponents[i];
            if (component.isEmpty()) continue;

            if (!current.hasChild(component)) {
                FileSystemNode newDir = new Directory(component);
                current.addChild(component, newDir);
            }
            FileSystemNode child = current.getChild(component);

            if (child.isFile()) {
                return false;
            }

            current = child;
        }


        String lastComponent = pathComponents[pathComponents.length - 1];
        if (lastComponent.isEmpty())
            return false;

        if (current.hasChild(lastComponent)) {
            return false; //already has the directory
        }

        FileSystemNode newNode = lastComponent.contains(".") ?
                new File(lastComponent) : new Directory(lastComponent);
        current.addChild(lastComponent, newNode);
        return true;
    }

    public void display() {
        root.display(0);
    }

    private String getParentPath(String path) {
        int lastSlash = path.lastIndexOf('/');
        if (lastSlash <= 0) {
            return "/";
        }

        return path.substring(0, lastSlash);
    }

    private FileSystemNode getNode(String path) {
        if (!isValidFilePath(path)) return null;
        if (path.equals("/")) return root;

        String[] pathComponents = path.split("/");
        FileSystemNode current = root;

        for (int i = 1; i < pathComponents.length; i++) {
            String component = pathComponents[i];
            if (component.isEmpty()) continue;

            if (!current.hasChild(component)) {
                return null;
            }
            FileSystemNode child = current.getChild(component);
            current = child;
        }

        return current;
    }

    public boolean deletePath(String path) {
        // path = "/document/cwa_lld/design_file_system"
        // Check if path is valid
        // Path is valid, so continue
        if (!isValidFilePath(path))
            return false;
        // Can't delete root
        // Path is not "/", so continue
        if (path.equals("/"))
            return false;
        // Get parent path
        // parentPath = "/document/cwa_lld"
        String parentPath = getParentPath(path);
        // Get the parent node
        // parent = "cwa_lld" directory node
        FileSystemNode parent = getNode(parentPath);
        // If parent doesn't exist or is a file, can't delete
        // Assuming parent exists and is a directory, continue
        if (parent == null || parent.isFile())
            return false;
        // Get the last component of the path
        // lastComponent = "design_file_system"
        String lastComponent = path.substring(path.lastIndexOf('/') + 1);
        // Check if the component exists
        // If "design_file_system" doesn't exist under "cwa_lld", return false
        if (!parent.hasChild(lastComponent)) {
            return false;
        }
        // Remove the child from the parent
        // Remove "design_file_system" from "cwa_lld"
        return parent.removeChild(lastComponent);
    }


    public boolean setFileContent(String path, String content) {
        FileSystemNode node = getNode(path);
        if (node == null || !node.isFile()) {
            return false;
        }

        File file = (File) node;
        file.setContent(content);
        return true;
    }

    public String getFileContent(String path) {
        FileSystemNode node = getNode(path);
        if (node == null || !node.isFile()) {
            return null;
        }

        File file = (File) node;
        return file.getContent();
    }
}
