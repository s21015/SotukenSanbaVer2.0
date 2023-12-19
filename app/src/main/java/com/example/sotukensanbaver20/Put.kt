package com.example.sotukensanbaver20

import android.content.Context
import com.example.sotukensanbaver20.database.MyEntity
import com.example.sotukensanbaver20.database.MyViewModel

class Put{
    fun getResourceUri(context: Context, resourceId: Int): String {
        return "android.resource://${context.packageName}/$resourceId"
    }

//    viewModel.insert(MyEntity(0,"", 5, getResourceUri(context, R.drawable.), ""))

    fun insertData(viewModel: MyViewModel, context: Context) {
        viewModel.insert(MyEntity(0, "りゅうきゅうけん",5, getResourceUri(context, R.drawable.dog),"体重：15〜20kg\n" +
                "体長：46〜55cm\n" +
                "毛色によって呼び名がある\n" +
                "縄文犬の一種\n" +
                "狼爪がある\n" +
                "舌斑がある\n"))
        viewModel.insert(MyEntity(0,"イリオモテヤマネコ", 5, getResourceUri(context, R.drawable.cat), "体重：3〜5kg\n" +
                "体長：50〜60cm\n" +
                "尾：23〜24cmで先端まで太い\n" +
                "分布：西表島\n" +
                "特別天然記念物に指定されている\n" +
                "ベンガルヤマネコの亜種\n" +
                "夜行性で、昼間は樹洞や岩穴などで休む\n" +
                "肉食で、日に400〜600g捕食する\n" +
                "野生下での寿命は推定7〜8歳\n"))
        viewModel.insert(MyEntity(0,"ヤンバルクイナ", 5, getResourceUri(context, R.drawable.yanbarukuina), "全長：35cm\n" +
                "翼長：15〜16cm　開長時：48〜50cm\n" +
                "体重340〜430g\n" +
                "”やんばる地方に棲むクイナ”が由来\n" +
                "卵は長径5cm、短径3.5cm\n" +
                "リュウキュウマツ林家海岸付近の民家周辺などで見られることもある\n" +
                "ほとんど飛翔することはできない\n" +
                "人間によって捨てられた犬や猫、外来種であるマングースなどによる捕食により生息数が減少\n"))
        viewModel.insert(MyEntity(0,"ジンベエザメ", 5, getResourceUri(context, R.drawable.jinbeizame), "全ての魚類の中で現生最大の種で、鯨類以外では最大の動物\n" +
                "全長：最大20m\n" +
                "体重：20t\n" +
                "幅：1.5m程度\n" +
                "細かな歯が300〜350本、\n" +
                "体色は腹部は白に近い灰色で、それ以外の全ての部分は色合いが濃い灰青色である\n" +
                "胴部には白い格子の中に淡黄色の斑点が配された模様があり、西欧ではチェス盤の模様に喩えられる\n" +
                "模様が着物の甚兵衛に似ていることから名付けられたとされる\n"))
        viewModel.insert(MyEntity(0,"サイカブト", 5, getResourceUri(context, R.drawable.kabutomushi), "サイのような湾曲した短い角をもつことに由来する\n" +
                "1970〜80年代にはカンシャカブト(甘蔗(サトウキビ)兜)と言う名も一部では使われた\n" +
                "本種の原産地はインドシナ半島周辺とされる\n" +
                "体長：30〜45mm\n" +
                "背面の体色は光沢のある黒色だが、若い個体は腹側に赤みが見られる\n" +
                "カブトムシに比べ外皮が厚く強固で、脚が太く短めで、棘が発達している\n" +
                "餌としては主に堆肥や、腐った草、牛糞などの繊維分が入っている土を好む\n" +
                "夜行性で、冬季の約二ヶ月を除いてほぼ一年中活動している\n" +
                "成虫の寿命は2〜5ヶ月ほど\n" +
                "ヤシや、パイナップル、サトウキビの害虫としても有名\n"))
        viewModel.insert(MyEntity(0,"ハイビスカス", 5, getResourceUri(context, R.drawable.hibiscus), "ハイビスカスは、ハワイ語では「アロアロ」と呼ばれる。"))
        viewModel.insert(MyEntity(0,"サトウキビ", 5, getResourceUri(context, R.drawable.satoukibi), "かつてはサトウキビ発祥の地は、現在のニューギニア島あたりで、紀元前6000年前後に現在のインド、さらに東南アジアに広まったといわれている。"))
        viewModel.insert(MyEntity(0,"ハブ", 5, getResourceUri(context, R.drawable.habu), "毒性はニホンマムシよりも弱いが、毒牙が1.5センチメートルと大型で毒量が100 - 300ミリグラムと多い。1回の咬傷にあたり平均22.5ミリグラム、最大103ミリグラムの毒液を排出する。"))
    }
}