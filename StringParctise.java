public class StringPractise {
    public static void main(String[] args) {
        String str = "abcd123.456";
        System.out.println(getNumberString(str)); // 输出: 123.45

        str = "abcd123";
        System.out.println(getNumberString(str)); // 输出: 123.00
    }

    public static String getNumberString(String str) {
        // 去掉前面的字母
        String numberPart = str.replaceAll("[^0-9.]", "");
        
        // 检查是否包含小数点
        if (numberPart.contains(".")) {
            // 截取小数点后两位，不四舍五入
            int index = numberPart.indexOf(".");
            if (index + 3 <= numberPart.length()) {
                numberPart = numberPart.substring(0, index + 3);
            } else {
                numberPart = numberPart.substring(0, numberPart.length());
            }
        } else {
            // 如果没有小数点，添加 .00
            numberPart = numberPart + ".00";
        }

        // 确保小数点后有两位
        if (numberPart.indexOf(".") == numberPart.length() - 2) {
            numberPart = numberPart + "0";
        }

        return numberPart;
    }
}
