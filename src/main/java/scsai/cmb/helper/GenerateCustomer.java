package scsai.cmb.helper;

import java.util.Date;
import java.util.Random;

import org.apache.commons.io.filefilter.RegexFileFilter;
import org.springframework.stereotype.Service;

import scsai.cmb.datasource.entity.Custom;
@Service
public class GenerateCustomer {
	private static String[] firstName = { "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩",
			"杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻",
			"柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞",
			"任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝", "邬",
			"安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和", "穆", "萧",
			"尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞",
			"熊", "纪", "舒", "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江",
			"童", "颜", "郭", "梅", "盛", "林", "刁", "钟", "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万",
			"支", "柯", "咎", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应", "宗", "宣", "丁", "贲", "邓", "郁", "单", "杭",
			"洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀", "羊", "於", "惠",
			"甄", "魏", "加", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧",
			"隗", "山", "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭",
			"厉", "戎", "祖", "武", "符", "刘", "姜", "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "薄", "印", "宿", "白",
			"怀", "蒲", "台", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠", "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双",
			"闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却", "璩", "桑", "桂", "濮",
			"牛", "寿", "通", "边", "扈", "燕", "冀", "郏", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连",
			"茹", "习", "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庚", "终", "暨", "居", "衡", "步", "都", "耿", "满",
			"弘", "匡", "国", "文", "寇", "广", "禄", "阙", "东", "殴", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂",
			"晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空", "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢",
			"关", "蒯", "相", "查", "后", "江", "红", "游", "竺", "权", "逯", "盖", "益", "桓", "公", "万", "俟", "司", "马", "上", "官",
			"欧", "阳", "夏", "侯", "诸", "葛", "闻", "人", "东", "方", "赫", "连", "皇", "甫", "尉", "迟", "公", "羊", "澹", "台", "公",
			"冶", "宗", "政", "濮", "阳", "淳", "于", "仲", "孙", "太", "叔", "申", "屠", "公", "孙", "乐", "正", "轩", "辕", "令", "狐",
			"钟", "离", "闾", "丘", "长", "孙", "慕", "容", "鲜", "于", "宇", "文", "司", "徒", "司", "空", "亓", "官", "司", "寇", "仉",
			"督", "子", "车", "颛", "孙", "端", "木", "巫", "马", "公", "西", "漆", "雕", "乐", "正", "壤", "驷", "公", "良", "拓", "拔",
			"夹", "谷", "宰", "父", "谷", "粱", "晋", "楚", "阎", "法", "汝", "鄢", "涂", "钦", "段", "干", "百", "里", "东", "郭", "南",
			"门", "呼", "延", "归", "海", "羊", "舌", "微", "生", "岳", "帅", "缑", "亢", "况", "后", "有", "琴", "梁", "丘", "左", "丘",
			"东", "门", "西", "门", "商", "牟", "佘", "佴", "伯", "赏", "南", "宫", "墨", "哈", "谯", "笪", "年", "爱", "阳", "佟", "第",
			"五", "言", "福", "百", "家", "姓", "续" };

	private int[] weight = { 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 };
	private char[] validate = { '1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2' };
	private Random random = new Random();
	public RegexFileFilter rx = new RegexFileFilter("/u4E00-/u9FFF");
	private IdCardNumber idCard = new IdCardNumber();
	public String getName() {
		StringBuffer sb = new StringBuffer(firstName[random.nextInt(firstName.length)]);
		int length = random.nextInt(2);
		for (int i = 0; i <= length; i++) {
			int x = 0x4E00;
			sb.append((char) (x + random.nextInt(20901)));
		}
		return sb.toString();
	}

	public char getValidateCode(String id17) {
		int sum = 0;
		int mode = 0;
		for (int i = 0; i < id17.length(); i++) {
			sum = sum + Integer.parseInt(String.valueOf(id17.charAt(i))) * weight[i];
		}
		mode = sum % 11;
		return validate[mode];
	}
	
	public String getPhone(){
		StringBuffer sb= new StringBuffer("1");
		for(int i=0;i<10;i++){
			sb.append(random.nextInt(10));
		}
		return sb.toString();
	}
	

	public int getSex() {
		return random.nextInt(2);
	}

	public String getAddress() {
		return AddressGenerate.generateAddress();
	}
	public String getCardType(){
		return "1";
	}

	public String getCardNumber(){
		return idCard.generate();
	}
	
	
	public Custom generateCustom(){
		Custom cust = new Custom();
		cust.setAddress(getAddress());
		cust.setCardNumb(getCardNumber());
		cust.setCardType(getCardType());
		cust.setCreateDate(new Date());
		cust.setName(getName());
		cust.setPhone(getPhone());
		cust.setSex(getSex());
		
		
		return cust;
	}
	public static void main(String[] args) {
		GenerateCustomer vv= new GenerateCustomer();
		IdCardNumber g = new IdCardNumber();
		System.out.println(g.generate());
		
		for(int i=0;i<100;i++){
			System.out.println(vv.getPhone());
		}
	}

}
