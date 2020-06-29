/****************
 * description: jquery插件第二个案例
 * author: yejf
 * version: 0.0.1
 * date: 2020/6/17
 */
//采用自调用, 并传入系统参数，这样可以提高加载的效率
;(function ($, window, document, undefined) {
    alert("加了jquery.plugin.demo3.js");
    //封装一个对象
    class CssDemo3 {
        //定义构造器
        constructor(element, options) {
            this.element = element;
            this.defaults = {
                'color': 'green',
                'fontSize': '16px',
                'textDecoration': 'none'
            } ;
            //存放参数
            this.options = $.extend({}, this.defaults, options);
        }
        //定义方法
        action() {
            return this.element.css({
                'color': this.options.color,
                'fontSize': this.options.fontSize,
                'textDecoration': this.options.textDecoration
            });
        }
    }

//通过插件扩展
    $.fn.demo3 = function (options) {
        //创建自定义对象
        let cssDemo3 = new CssDemo3(this, options);
        //调用方法
        return cssDemo3.action();
    }

})(jQuery, window, document);
