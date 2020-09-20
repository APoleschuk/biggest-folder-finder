public class SizeCalculator {

  public static String getHumanReadableSize(long size) {
    char[] sizeMulpitliers = {'B', 'K', 'M', 'G'};
    for (int i = 0; i < sizeMulpitliers.length; i++) {
      double value = ((double) size) / Math.pow(1024., i);
      if (value < 1024) {
        return (Math.round(value * 100)) / 100. + "" + sizeMulpitliers[i] + (i > 0 ? "b" : "");
      }
    }
    return "Very big size";
  }

  public static long getSizeFromHumanReadable(String size) {
    String numbers = size.replaceAll("[^0-9]", "");
    String letters = size.replaceAll("[^a-zA-Z]", "");
    return switch (letters) {
      case "B" -> (long) Float.parseFloat(numbers);
      case "K", "Kb" -> (long) (Float.parseFloat(numbers) * (long) Math.pow(1024, 1));
      case "M", "Mb" -> (long) (Float.parseFloat(numbers) * (long) Math.pow(1024, 2));
      default -> (long) (Float.parseFloat(numbers) * Math.pow(1024, 3));
    };
  }

}
