package FileSystem;

public class File extends FileSystemNode {
    private String content;
    private String extension;

    public File(String name) {
        super(name);
        this.extension = extractExtensiton(name);
    }

    private String extractExtensiton(String name) {
        int dotIdx = name.lastIndexOf('.');
        return (dotIdx >= 0) ? name.substring(dotIdx + 1) : "";
    }

    public void setContent(String content) {
        this.content = content;
        updateModifiedTime();
    }

    public String getContent() {
        return content;
    }

    @Override
    public boolean isFile(){
        return true;
    }

    @Override
    public void display(int depth){
        String indent = " ".repeat(depth * 2);
        System.out.println(indent + "📄 " + getName());
    }
}
