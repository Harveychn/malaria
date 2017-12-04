![mahua](mahua-logo.jpg)
##三大模块：
####1.数据输入与输出模块(设计表格）
    1.原始数据输入：
        1.原始数据输入：
		    1.需求：
		    文件上传，根据第一行字段判断文件类型
		    通过用户界面将新的原始信息数据输入到服务器中。
		    前端页面将原始数据通过HTTP协议传输到后台。

		    ！ 多表格批量同时上传、有出错信息则提示。

		    后台对原始数据进行分析、处理，并将结果按照 预定义的格式 存入到数据库中。
	    2.表格：（参考下面的数据库表格设计【目前固定字段位置】）
		3.前后台交互：
			前台：	选择文件上传的类别（及数据库对应数据表格）
				提交文件流（文件格式目前为.xls）
			后台：	对文件流进行数据的获取，封装数据，保存到数据库的相应表格中

		4.数据上传文件字段顺序约定：
		    card_information:
	    	【数据信息年份、卡片ID、卡片编号、卡片状态】
		    patient_information:
		       【数据信息年份、卡片ID、患者姓名、性别、职业、出生日期、年龄、患者工作单位、联系电话、病人属于、现住详细地址、、现住地址国标】
		    patient_cases_information:
		    【数据信息年份、卡片ID、病例分类、病例分类2、发病日期、诊断时间、死亡日期、疾病名称、填卡医生、医生填卡日期、备注
		    case_report_information
		    【数据信息年份、卡片ID、报告单位地区编码、报告单位、单位类型、报告卡录入时间、录卡用户、录卡用户所属单位】
		    case_revised_information
		    【数据信息年份、卡片ID、订正前病种、订正报告时间、订正终审时间、终审死亡时间、订正用户、订正用户所属单位、删除时间、删除用户、删除用户所属单位、删除原因】
		    case_judgment_information
		    【数据信息年份、卡片ID、省市审核时间、县区审核时间、地市审核时间、审核状态】
		    weather_data
		    【区站号、年、月、日、20-20时降水量、极大风速、极大风速的风向、平均本站气压、平均风速、	平均气温、平均水汽压、平均相对湿度
			    日照时数、日最低本站气压、日最低气温、日最高本站气压、日最高气温、最大风速、最大风速的风向、最小相对湿度】
		    meteorological_station_information
		    【区站号、台站名称、省份、纬度(度分)、经度(度分)、海拔高度(0.1米)、开始年份、开始月份、截止年份、截止月份、缺测情况】

		    * 约定
		        * 0:card_information
		        * 1:上传数据到patient_information
		        * 2:上传数据到patient_cases_information
		        * 3:case_report_information
		        * 4:case_revised_information
		        * 5:case_judgement_information
		        * 6:weather_data
		        * 7:meteorological_station_information 
    2.原始数据下载：
		1.疟疾数据下载：
			1.需求：
				1.筛选数据条件：
					疟疾：地区、时间、性别、年龄
					选择字段：全部疟疾字段
				2.需要的数据：
					筛选数据：
						地区：多级联动到乡、
						时间：时间选择、
						性别：男、女、全部、
						年龄：0-100区间内
					后台工作：
						查询数据字段到前端，供用户选择
					前台数据提交：
						选择好的 字段、年龄、时间区间、地区【地区 (应该区分为省市区镇乡)】、性别
				3.需要的表格：
					indicator表【数据字段类别、数据库字段名、数据库表名、数据库表的别名、展示字段名、】
					indicator【category、fieldName、belongTable、tableAlias、displayName】

				4.流程：
					【1】用户点击模块（三大模块【疟疾数据，气候数据，台站数据】）进入页面
							前台提交参数：category
							后台返回数据：可下载的fieldNames
						后台返回可下载数据字段（其余均用js实现）
					前台提交查询参数【筛选条件、数据字段】  --封装类 : DownloadParamVo
					根据数据字段到indicator表格查询信息，返回List<Indicator>
						查询List<Indicator>SQL语句：
							SELECT * FROM indicator WHERE displayName in ('卡片ID',
								'删除原因','删除时间','删除用户','删除用户所属单位','医生填卡日期','单位类型','卡片状态','县区审核时间',
								'备注,审核状态','年龄','录卡用户','录卡用户所属单位','性别','报告单位,报告单位地区编码','报告卡录入时间','数据信息年份'
							)
							AND downable =1
							GROUP BY fieldName
							ORDER BY displayName ASC;
						处理List<Indicator>:
							patient_information 必有
							1.查询的字段名 格式   ： [tableAlias].[fieldName]
							2.查询的表名 格式 ： [belongTable] [tableAlias]
							3.查询的筛选条件： 以patient_informaton 中的  year ，address ，sex ，birthday 来确定
							3.注意：连接条件 一定要有，否则会出现崩溃！！！

					将得到的结果用mybatis动态sql查询动态数据
						【注意：Service中Address未处理】
						1.根据省市镇村去模糊查询数据
					判断是否有数据，有则table展示数据
					用户点击下载，利用POI写入excel表格（考虑到兼容性，用HSSF）
					输出下载流到用户端
					下载完成

		2.气候数据下载：（category = "Weather"）
			1.需求：
				1.筛选数据条件：
					气候：时间段、地区
					选择字段：全部气候数据字段
		3.观测站数据下载：(category = "Station")
			1.需求：
				1.筛选数据条件：
					观测站：全部信息
					观测站数据字段（只提供字段选择）



####2.疟疾爆发模块（真实数据库中数据）
	【不采用】实现方法：
		说明：热力图展示效果很大程度受到count的值影响，所以目前精确到地理级别为 ：town
		预处理步骤：根据查询 DISTINCT provinceName,cityName,countyName,townName 封装到Pretreatment 类中
			对List<Pretreatment> 进行遍历，查询 COUNT 数量值
			将结果封装成类，并保存到MySql数据库表格中
		表格设计：
			disease_outbreak【breakYear，breakMonth，province，city，county，town，caseNum】
			【PK（爆发年份，爆发月份，省份，城市，县区，乡镇，）病例数】
	【测试解决办法】：
		查询address到前台，调用百度API地址解析解析地址为经纬度，将经纬度传回后台保存
		保存表格：
			address
    	2.1 动态爆发
		    1.需求--时间线
			    时间、病例数、空间（省、市、县、村）
			    【2005-2011年以季度显示，以村为单位统计病例】
		    2.表格
			    空间：patient_information中的Address，
				    数据格式：JSON
			    时间：patient_cases_information中的illDate（年、月），

			    病例数：address的count值（String数组的size（）值）
				    数据格式：long
		    3.SQL语句：

		    4.前后端交互
			    前段传递参数：年、月、省份（该值 “空” 则默认为全部的数据）
			    后台返回数据：详细地址address的String数组、以及病例数（即address数目）

	    2.2 热力图
		    1.需求--总体情况
			    时间跨度：2005-2011 、空间跨度（以村为单位）、总体病例的感染情况、侧重于展示疟疾总数和空间区域之间的关系
			    提供一种基于地点的疾病爆发情况分析。（2005年到2011年全部的病例分布热力图，以村为单位统计的病例）
		    2.表格
			    patient_case_information（发病日期） 、 patient_information（地址，及总数）
		    3.前后台交互
			    前端提交：时间跨度（开始年份2005，结束年份2011）、省份

	    2.3 相关数据
		    1.工作类型：
			    需求：从云南省腾冲县2005-2011年疟疾患病人群分类分析发现，
				    民工占据了近80.5%，占所有患病人数的大多数。
				    其次，农民占据了近16.4%。剩余3.6%的部分主要为学生儿童，商业服务，海员以及长途驾驶员等。
				    患病人群分类的分析结果也为本文假设腾冲县疟疾的染病者主要是由于人们外出打工，染病后的归国人员提供强有力的依据。
			    表格：
				    patient_information（career）
			    	时间区间：2005-2011

			    SQL语句：
				    SELECT pi.career careerCategory,COUNT(pi.career) patientNum FROM patient_information pi
				    WHERE (pi.`year` BETWEEN 2005 AND 2011) AND ( pi.address LIKE '云南%') GROUP BY pi.career ;

			    前后台交互：
				    前台：传入数据区间 （beginYear、endYear）（不赋值，则默认全部数据），
					    省份（不赋值，则默认全部数据，当前查询只可以单个省）
				    后台：返回职业类别及对应职业的病人数目

		    2.年龄组：
			    需求：从云南省腾冲县2005-2011年疟疾患病人群年龄组分析发现，
				    患病人群主要分布在20-49岁，
				    而事实上我国的劳动力也在此年龄区间。
			    表格：
				    patient_information(虚岁，手动查询：计算方法：数据年份-生日年份+1 = 虚岁 )
				    时间区间：2005-2011
			    SQL语句：
				    SELECT COUNT((pi.`year`-YEAR(pi.birthday)+1)) AS virtualAge FROM patient_information pi
				    WHERE (pi.address LIKE '云南%')
				    AND ((pi.`year`-YEAR(pi.birthday)+1) BETWEEN 0 AND 9);

			    前后台交互：
				    前台：传入时间区间（beginYear、endYear）（不赋值，则默认全部数据），
					    省份（不赋值，则默认全部数据，当前查询只可以单个省）
					    此时不指定年龄跨度（即默认区间跨度为“10”,pojo类指定好）
				    后台：返回区间及相应的patientNum

		    3.人群性别：
			    需求：从云南省腾冲县2005-2011年疟疾患病人群性别分析发现，
				    男性占据90%以上。
				    由于患者男女比例悬殊，加之外出打工人群多为男性，因此这也为本文假设大多数患者为外出打工人员奠定基础。
			    表格：patient_information(sex)
				    时间区间：2005-2011

			    SQL语句：
				    SELECT pi.sex sex,COUNT(pi.sex) FROM patient_information pi
					    WHERE (pi.`year` BETWEEN 2005 AND 2011)
					    AND pi.address LIKE '云南%'
					    GROUP BY sex;

			    前后台交互：
				    前台：传入时间区间（beginYear、endYear）（不赋值，则默认全部数据），
					    省份（不赋值，则默认全部数据，当前查询只可以单个省）
				    后台：返回男病例人数、女病例人数

####表格设计
	    卡片信息（数据信息年份【PK】、卡片ID【PK】、卡片编号、卡片状态）

		card_information(year【int】,cardID【int】,cardNum,cardStatus)

	患者个人信息（数据信息年份【PK】、卡片ID【PK】、患者姓名、性别、出生日期、年龄、患者工作单位、联系电话、职业、病人属于、现住详细地址、现住地址国标）

		patient_information(year【int】,cardID【int】,name,sex,birthday,age,company,tel,career,belongs,address,addrNationID)--12

	患者病例信息（数据信息年份【PK】、卡片ID【PK】、病例分类、病例分类2、发病日期、诊断时间、死亡日期、疾病名称、填卡医生、医生填卡日期、备注）

		patient_cases_information(year【int】,cardID【int】,caseCategory1,caseCategory2,illDate,confirmDate,deathDate,diseaseName,fillCardDoc,fillCardDate,notes)--11

	病例报告信息（数据信息年份【PK】、卡片ID【PK】、报告单位地区编码、报告单位、单位类型、报告卡录入时间、录卡用户、录卡用户所属单位）

		case_report_information(year【int】,cardID【int】,reportUnitAreaCode,reportUnit,unitType,reportInputDate,inputUser,inputUserUnit)--8

	病例审核信息（数据信息年份【PK】、卡片ID【PK】、县区审核时间、地方审核时间、省市审核时间、审核状态）

		case_judgment_information(year【int】,cardID【int】,countyJudgDate,localJudgDate,provinceJudgDate,judgStatus)--6

	病例订正信息（数据信息年份【PK】、卡片ID【PK】、订正前病种、订正报告时间、订正终审时间、终审死亡时间、订正用户、订正用户所属单位、删除时间、删除用户、删除用户所属单位、删除原因）

		case_revised_information(year【int】,cardID【int】,diseasePreRevised,revisedReportDate,revisedFinalJudgDate，finalJudgDeathDate,reviseUser,reviseUserUnit,delDate,delUser,delUserUnit,delReason)--12

	气候数据信息（）

	观测站信息（）
