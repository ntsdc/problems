public class colorFilling {


    public static void main(String[] args) {
        int[][] image = {{0,0,0}, {0,0,0}};
        Solution solution = new Solution();
        solution.floodFill(image, 0, 0, 2);
        System.out.println("");
    }
}


class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int pre_color = image[sr][sc];
        image[sr][sc] = color;
        if (sr + 1 < image.length && image[sr+1][sc]==pre_color) floodFill(image, sr + 1, sc, color);
        if (sc + 1 < image[sr].length && image[sr][sc+1]==pre_color) floodFill(image, sr, sc + 1, color);
        if (sr - 1 >= 0 && image[sr-1][sc]==pre_color) floodFill(image, sr - 1, sc, color);
        if (sc - 1 >= 0&& image[sr][sc-1]==pre_color) floodFill(image, sr, sc - 1, color);
        return image;
    }
}