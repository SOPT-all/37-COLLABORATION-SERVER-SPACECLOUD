package org.sopt.collaboration.domain.place.entity.enums.place;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Location {
	GANGNAM_YEOKSAM_SEONLEUNG_SAMSUNG("강남역·역삼·선릉·삼성"),
	SINSA_NONHYEON_CHEONGDAM_APGUJEONG("신사·논현·청담·압구정"),
	SEOCHO_GYODAE_BANGBAE("서초·교대·방배"),
	SEONGSU_WANGSIMNI_SEOULFOREST("성수·왕십리·서울숲"),
	JONGNO_GWANGHWAMUN_DAEHANGNO("종로·광화문·대학로"),
	YONGSAN_ITAEWON_HANNAM("용산·이태원·한남"),
	GWANGJIN_KONKUK_GUUI_GUNJA("광진·건대·구의·군자"),
	SEONGBUK_SUNGSHIN_ANAM("성북·성신여대·안암"),
	DOGOK_DAECHI_GAECHE_SUSUEO("도곡·대치·개포·수서"),
	GURO_SINDORIM_GOCHEOK("구로·신도림·고척"),
	GANGDONG_SEONGNAE_CHEONHO_GILDONG("강동·성내·천호·길동"),
	YANGCHEON_MOKDONG_SINJEONG("양천·목동·신정"),
	NOWON_SANGGYE_GONGLEUNG("노원·상계·공릉"),
	JUNGNANG_SANGBONG_MYEONMOK("중랑·상봉·면목"),
	HONGDAE_HAPJEONG_SANGSU_YEONNAM("홍대·합정·상수·연남"),
	SINCHON_EHWA_AHYEON_YEONHUI("신촌·이대·아현·연희"),
	MANGWON_SEONGSAN_SANGAM("망원·성산·상암"),
	MYEONGDONG_EULJIRO_DONGDAEMUNSTATION("명동·을지로·동대문역"),
	YEONGDEUNGPO_YEOUIDO_DANGSAN_MUNRAE("영등포·여의도·당산·문래"),
	SONGPA_JAMSIL_BANGI("송파·잠실·방이"),
	GWANAK_SILLIM_SNUSTATION("관악·신림·서울대입구"),
	DONGJAK_SADANG_ISU("동작·사당·이수"),
	GANGSEO_MAGOK_HWAGOK("강서·마곡·화곡"),
	MAPO_GONGDEOK_DAEHEUNG("마포역·공덕·대흥"),
	GEUMCHEON_GASAN_DOKSAN("금천·가산·독산"),
	DONGDAEMUNGU_CHEONGRYANGRI_HOEGI("동대문구·청량리·회기"),
	EUNPYEONG_BULGWANG_YEONSINNAE("은평·불광·연신내"),
	GANGBUK_SUYU_MIA("강북·수유·미아"),
	DOBONG_SSANGMUN_CHANGDONG("도봉·쌍문·창동");

	private final String description;
}
