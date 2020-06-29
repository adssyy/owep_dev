/****************
 * description: jquery插件第二个案例
 * author: yejf
 * version: 0.0.1
 * date: 2020/6/17
 */
//考虑到变量的命名空间冲突，改为 自调用模式, 前面加一个 分号，以保证与其它插件混合使用时，前面少了分号
;(function($, window, document, undefined) {
    console.log($);
    console.log(window);
    console.log(document);
    console.log(undefined);
    //封装一个对象
    var CssDemo = function (element, options) {
        //接收传入的参数
        this.$element = element;
        //定义一个默认的选项
        this.defaults = {
            'color': 'red',
            'fontSize': '12px',
            'textDecoration': 'none'
        };
        //利用 $.extend 方法来组装参数
        this.$options = $.extend({}, this.defaults, options);
    }
//扩展出 CssDemo的方法
    CssDemo.prototype = {
        //定义方法
        action: function () {
            //
            return this.$element.css({
                'color': this.$options.color,
                'fontSize': this.$options.fontSize,
                'textDecoration': this.$options.textDecoration
            });
        }
    }

//通过插件扩展
    $.fn.demo2 = function (options) {
        //创建自定义对象
        var cssDemo = new CssDemo(this, options);
        //调用方法
        return cssDemo.action();
    }

})(jQuery, window, document);
