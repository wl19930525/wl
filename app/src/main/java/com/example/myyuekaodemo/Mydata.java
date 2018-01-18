package com.example.myyuekaodemo;

import java.util.List;

/**
 * Created by 执笔画商
 * on 2018/1/16.
 * at 北京
 */

public class Mydata {

    /**
     * beaner : ["https://img.alicdn.com/tfs/TB17E6lmgDD8KJjy0FdXXcjvXXa-520-280.jpg_q90_.webp","https://gw.alicdn.com/bao/uploaded/TB1UUMZSFXXXXbuaFXXSutbFXXX.jpg_440x440","https://img.alicdn.com/tfs/TB1UmcjRVXXXXa9apXXXXXXXXXX-520-280.jpg_q90_.webp"]
     * color : ["#ff0000","#00ff00"]
     * name : 商品名称
     * price : 商品价格
     * size : [{"sizeCount":"20","sizeName":"S"},{"sizeCount":"20","sizeName":"M"},{"sizeCount":"20","sizeName":"L"},{"sizeCount":"20","sizeName":"XL"},{"sizeCount":"0","sizeName":"XXL"}]
     */

    private String name;
    private String price;
    private List<String> beaner;
    private List<String> color;
    private List<SizeBean> size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<String> getBeaner() {
        return beaner;
    }

    public void setBeaner(List<String> beaner) {
        this.beaner = beaner;
    }

    public List<String> getColor() {
        return color;
    }

    public void setColor(List<String> color) {
        this.color = color;
    }

    public List<SizeBean> getSize() {
        return size;
    }

    public void setSize(List<SizeBean> size) {
        this.size = size;
    }

    public static class SizeBean {
        /**
         * sizeCount : 20
         * sizeName : S
         */

        private String sizeCount;
        private String sizeName;

        public String getSizeCount() {
            return sizeCount;
        }

        public void setSizeCount(String sizeCount) {
            this.sizeCount = sizeCount;
        }

        public String getSizeName() {
            return sizeName;
        }

        public void setSizeName(String sizeName) {
            this.sizeName = sizeName;
        }
    }
}
