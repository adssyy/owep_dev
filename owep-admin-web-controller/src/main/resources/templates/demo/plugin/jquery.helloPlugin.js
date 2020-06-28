/************
 * 一个最简单的jquery插件
 */
$.fn.helloPlugin = function (options) {
    //利用 $.extend({}) 方法来存储参数，同时，我们要提供默认的参数，并且同时放入到 extend 方法中，如果有相同的属性，则会被覆盖
    var defaults = {
        "color": "red",
        "fontSize": "12px"
    };
    //下面的这种写法 options如果有与defaults一样的键时，defaults的值会被覆盖，如果不希望被覆盖，则我们引入一个新的空参数
    //var settings = $.extend(defaults, options);
    var settings = $.extend({}, defaults, options);
    console.log("defaults: "+JSON.stringify(defaults));
    console.log("options: "+JSON.stringify(options));
    console.log("settings: "+JSON.stringify(settings));
    //在这里可以 this 来表示被 jquery选中的元素
    console.log("在我自己定义的插件中，修改前景色为 红色");
    //注：这里的this本身就是 jquery对象，无需使用 $ 修饰
    //this.css("color", settings.color);
    //this.css("font-size", settings.fontSize);
    this.css({
       "color": settings.color,
       "fontSize": settings.fontSize
    });
    //我们迭代传进来的每一个元素
    return this.each(function (index, element) {
        console.log("第"+index+"个元素是："+element);
        //这里面如果要表示当前迭代的元素，则可以使用 $(this)
        $(this).append(" "+$(this).attr("href"));
    });
}