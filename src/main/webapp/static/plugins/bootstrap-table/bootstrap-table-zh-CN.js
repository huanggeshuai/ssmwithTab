(function (global, factory) {
  if (typeof define === "function" && define.amd) {
    define([], factory);
  } else if (typeof exports !== "undefined") {
    factory();
  } else {
    var mod = {
      exports: {}
    };
    factory();
    global.bootstrapTableZhCN = mod.exports;
  }
})(this, function () {
  'use strict';

  /**
   * Bootstrap Table Chinese translation
   * Author: Zhixin Wen<wenzhixin2010@gmail.com>
   */
  (function ($) {
    $.fn.bootstrapTable.locales['zh-CN'] = {
      formatLoadingMessage: function formatLoadingMessage() {
        //正在努力地加载数据中，请稍候
        return '&#x6B63;&#x5728;&#x52AA;&#x529B;&#x5730;&#x52A0;&#x8F7D;&#x6570;&#x636E;&#x4E2D;&#xFF0C;&#x8BF7;&#x7A0D;&#x5019;......';
      },
      formatRecordsPerPage: function formatRecordsPerPage(pageNumber) {
        return '\u6BCF\u9875\u663E\u793A ' + pageNumber + ' \u6761\u8BB0\u5F55';
      },
      formatShowingRows: function formatShowingRows(pageFrom, pageTo, totalRows) {
        return '\u663E\u793A\u7B2C ' + pageFrom + ' \u5230\u7B2C ' + pageTo + ' \u6761\u8BB0\u5F55\uFF0C\u603B\u5171 ' + totalRows + ' \u6761\u8BB0\u5F55';
      },
      formatSearch: function formatSearch() {
        //搜索
        return '&#x641C;&#x7D22;';
      },
      formatNoMatches: function formatNoMatches() {
        //没有找到匹配的记录
        return '&#x6CA1;&#x6709;&#x627E;&#x5230;&#x5339;&#x914D;&#x7684;&#x8BB0;&#x5F55;';
      },
      formatPaginationSwitch: function formatPaginationSwitch() {
        //隐藏/显示分页
        return '&#x9690;&#x85CF;/&#x663E;&#x793A;&#x5206;&#x9875;';
      },
      formatRefresh: function formatRefresh() {
        //刷新
        return '&#x5237;&#x65B0;';
      },
      formatToggle: function formatToggle() {
        //切换
        return '&#x5207;&#x6362;';
      },
      formatColumns: function formatColumns() {
        //列
        return '&#x5217;';
      },
      formatExport: function formatExport() {
        //导出数据
        return '&#x5BFC;&#x51FA;&#x6570;&#x636E;';
      },
      formatClearFilters: function formatClearFilters() {
        //清空过滤
        return '&#x6E05;&#x7A7A;&#x8FC7;&#x6EE4;';
      }
    };

    $.extend($.fn.bootstrapTable.defaults, $.fn.bootstrapTable.locales['zh-CN']);
  })(jQuery);
});
