import java.io.File;

public class ParametersBag {

  private long limit = 0;
  private String path = "";

  public ParametersBag(String[] args) {
    setPath(args);
    setLimit(args);
    File file = new File(path);
    if(!file.exists() || !file.isDirectory()) {
      throw new IllegalArgumentException("Такого файла или папки не существует");
    }
    else if (getPath().equals("")) {
      throw new IllegalArgumentException("Не указан путь к папке, задается через параметр -d");
    }
    else if (getLimit() == 0) {
      throw new IllegalArgumentException("Не задан лимит, задается через параметр -l");
    }
  }

  private void setLimit(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-l")) {
        limit = SizeCalculator.getSizeFromHumanReadable(args[i + 1]);
      }
    }
  }

  public long getLimit() {
    return limit;
  }

  private void setPath(String[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("-d")) {
        path = args[i + 1];
      }
    }
  }

  public String getPath() {
    return path;
  }
}
