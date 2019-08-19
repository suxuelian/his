/**
 * 灏嗕笉瓒�10浣嶇殑鏁板�硷紝杞崲涓洪暱搴︿负10鐨勫瓧绗︿覆
 * @param {number} num 
 */
function getTenStr(num) {
	// 灏唍um杞崲鎴愬瓧绗︿覆锛屾牴鎹瓧绗︿覆闀垮害鑾峰緱姝ｇ‘鐨勬暟鍊间綅鏁�
	var str = num + "";
	var len = str.length;
	// 鏍规嵁瀛楃涓查暱搴﹁繘琛屼綅鏁拌ˉ鍏紝琛ュ叏鍒�10浣嶏紝涓嶈冻浣嶆坊0
	if(len < 6) {
		for(var i = 0; i < 10 - len; i++) {
			str = "0" + str;
		}
	}
	return str;
}

/**
 * 鏍规嵁鏃ユ湡绠楀嚭骞撮緞
 * 鑾峰緱"鍑虹敓鏃ユ湡"杈撳叆妗嗙殑鍊硷紝鏍煎紡涓�"yyyy-MM-dd"
 * @param select
 * @returns
 */
function getAgeByBirthday(birth) {
	// 瀵硅幏寰楃殑"鍑虹敓鏃ユ湡"瀛楃涓茶繘琛屾媶鍒嗭紝寰楀埌骞淬�佹湀銆佹棩鐨勫瓧绗︿覆
	var _year = birth.substring(0, birth.indexOf("-"));
	var _month = birth.substring(birth.indexOf("-") + 1, birth.lastIndexOf("-"));
	var _date = birth.substring(birth.lastIndexOf("-") + 1, birth.length);
	// 灏嗗勾銆佹湀銆佹棩鐨勫瓧绗︿覆杞崲涓虹浉搴旂殑鏁板��
	var y = parseInt(_year);
	var m = parseInt(_month) - 1;
	var d = parseInt(_date);
	// 鑾峰緱"鍑虹敓鏃ユ湡"鐨勬椂闂存埑
	var birthTime = new Date(y, m, d).getTime();
	// 鑾峰緱褰撳墠鏃堕棿鐨勬椂闂存埑
	var nowTime = new Date().getTime();
	// 璁＄畻鍑虹浉宸殑鏃堕棿
	var c = nowTime - birthTime;

	var age = Math.floor(c / (365 * 24 * 60 * 60 * 1000));
	if(age < 1) {
		age = Math.floor(c / (30 * 24 * 60 * 60 * 1000));
		if(age < 1) {
			age = Math.floor(c / (24 * 60 * 60 * 1000));
		}
	}
	// 涓�"骞撮緞"杈撳叆妗嗚祴鍊�
	return age;
}


// 鏍煎紡鍖栨椂闂�
// 璋冪敤渚嬪瓙锛� formatDate(new Date(鏀惧叆鏃堕棿鎴�))
function formatDate(now) {
	var year = now.getFullYear();
	var month = now.getMonth() + 1;
	var date = now.getDate();
	var hour = now.getHours();
	var minute = now.getMinutes();
	var second = now.getSeconds();
	return year + "-" + month + "-" + date;
}


/**
 * 根据名字获取URL值
 * @param name
 * @returns
 */
function getQueryString(name) {
  var reg = new RegExp('(^|&)' + name + '=([^&]*)(&|$)', 'i');
  var r = window.location.search.substr(1).match(reg);
  if (r != null) {
    return unescape(r[2]);
  }
  return null;
}

//金额转中文大写
function number_chinese(str) {
    var num = parseFloat(str);
    var strOutput = "",
        strUnit = '仟佰拾亿仟佰拾万仟佰拾元角分';
    num += "00";
    var intPos = num.indexOf('.');  
    if (intPos >= 0){
        num = num.substring(0, intPos) + num.substr(intPos + 1, 2);
    }
    strUnit = strUnit.substr(strUnit.length - num.length);
    for (var i=0; i < num.length; i++){
        strOutput += '零壹贰叁肆伍陆柒捌玖'.substr(num.substr(i,1),1) + strUnit.substr(i,1);
    }
    return strOutput.replace(/零角零分$/, '整').replace(/零[仟佰拾]/g, '零').replace(/零{2,}/g, '零').replace(/零([亿|万])/g, '$1').replace(/零+元/, '元').replace(/亿零{0,3}万/, '亿').replace(/^元/, "零元")

}
