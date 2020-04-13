package com.modtion.fightcovid.utils

import com.modtion.fightcovid.model.Hospital
import java.util.*
import kotlin.collections.ArrayList

class HospitalData {

    fun getHistoryList(city:String) : List<Hospital>{
        val list =  ArrayList<Hospital> ()

        when(city) {
            "Aceh" -> {
                list.add(Hospital("Rumkit Tk II Banda Aceh","Alamat Jl. T. Angkasa Bendahara, Kuta Alam, Kec. Kuta Alam, Kota Banda Aceh, Aceh 24415","Telepon (0651) 24712"))
                list.add(Hospital("RSU Dr. Zainoel Abidin Banda Aceh","Alamat Jl. Tgk. Daud Beureuh No. 108, Banda Aceh","Telepon (0651) 34562"))
                list.add(Hospital("Rumkit TK IV Meulaboh","Alamat Suwak Indrapuri, Johan Pahlawan, Kabupaten Aceh Barat, Aceh 23681", ""))
                list.add(Hospital("Rumkit Tk. IV LHokseumawe","Alamat JL. Samudera, Hagu Sel., Banda Sakti, Kota Lhokseumawe, Aceh","Telepon (0645) 40300"))
                list.add(Hospital("RSU Cut Meutia Lhokseumawe","Alamat Jl. Banda Aceh Medan KM 5 Buket Rata, Lhokseumawe","Telepon (0645) 46334"))
            }
            "Sumatera Utara" -> {
                list.add(Hospital("RSAL-3 KOMANG MAKES","Alamat Jl. Bengkalis No.1, Belawan I, Medan Kota Belawan, Kota Medan, Sumatera Utara 20411","Telepon (061) 6941741"))
                list.add(Hospital("Rumkit Tk.IV/Binjai","Alamat Jl. Bandung, Rambung Barat no 4 Binjai Selatan, Kota Binjai, Sumatera Utara 20735","Telepon (061) 8827705"))
                list.add(Hospital("Rumkit Tk. II/ Putri Hijau Medan","Alamat Jl. Putri Hijau No.17, Kesawan, Kec. Medan Bar., Kota Medan, Sumatera Utara 20111","Telepon (061) 4553900"))
                list.add(Hospital("Tk II Medan","Alamat Jl. K.H. Wahid Hasyim No.1, Merdeka, Kec. Medan Baru, Kota Medan, Sumatera Utara 20222","Telepon (061) 8215990"))
                list.add(Hospital("RSAU-4 DR. ABDUL MALIK LANUD SWO","Alamat Jl. Imam Bonjol No.50, Suka Damai, Kec. Medan Polonia, Kota Medan, Sumatera Utara 20157","Telepon (061) 4572323"))
                list.add(Hospital("RSU H. Adam Malik Medan","Alamat Jl. Bunga Lau No. 17","Telepon (061) 8360051"))
                list.add(Hospital("Tk III Tebing Tinggi","Alamat Jl. Pahlawan No.17, Rambung, Kec. Tebing Tinggi Kota, Kota Tebing Tinggi, Sumatera Utara 20631","Telepon (0621) 326701"))
                list.add(Hospital("RSU Kabanjahe","Alamat Jl. Selamat Ketaren, Lau Cimba, Kabanjahe, Kabupaten Karo, Sumatera Utara 22111","Telepon (0628) 20012"))
                list.add(Hospital("Rumkit Tk. IV/Pematang Siantar","Alamat Jl. Gunung Simanuk Manuk No.6, Timbang Galung, Kec. Siantar Bar., Kota Pematang Siantar, Sumatera Utara 21143",""))
                list.add(Hospital("RSUD Dr. Djasamen Saragih","Alamat Jl. Sutomo No. 230, Pematang Sianta","Telepon (0622) 22959"))
                list.add(Hospital("RSU Tarutung","Alamat Jl. Agus Salim No.1 Tarutung, Kab. Tapanuli Utara","Telepon (0633) 21303 , 20450"))
                list.add(Hospital("Rumkit Tk. IV/Padang Sidempuan","Alamat Jl. Padang Sidempuan, Losung Batu, Padangsidimpuan Utara, Kota Padang Sidempuan, Sumatera Utara 22733",""))
                list.add(Hospital("RSU Padang Sidempuan","Alamat Jl. Dr. FL Tobing, Padang Sidempuan","Telepon 0634 21780 Fax: 0634 21251"))
            }
            "Sumatera Barat" -> {
                list.add(Hospital("RSU Dr. Achmad Mochtar","Alamat Jl. Dr. A. Rivai, Bukittinggi","Telepon 0752 21720"))
                list.add(Hospital("Rumkit Tk.IV/Bukit Tinggi","Alamat Jl. Sudirman, Birugo, Kec. Aur Birugo Tigo Baleh, Kota Bukittinggi, Sumatera Barat 26181","Telepon (0752) 8100746"))
                list.add(Hospital("Rumkit Tk. IV/Solok","Alamat JL. Proklamasi, No. 3, VI Suku, Lubuk Sikarah, Kp. Jawa, Tj. Harapan, Kota Solok, Sumatera Barat 27317","Telepon (0755) 325457"))
                list.add(Hospital("TK III Padang","Alamat Jl. Jati No.1, Jati Baru, Kec. Padang Tim., Kota Padang, Sumatera Barat 25129","Telepon (0751) 22270"))
                list.add(Hospital("Rumkit Tk. III/dr.Reksodiwiryo Padang","Alamat Jl. Dr. Wahidin No.1, Ganting Parak Gadang, Kec. Padang Tim., Kota Padang, Sumatera Barat 25132","Telepon (0751) 31003"))
            }
            "Riau" -> {
                list.add(Hospital("RSU Dumai","Alamat Jl. Tanjung Jati No.4, Dumai","Telepon (0765) 440992"))
                list.add(Hospital("Rumkit Tk. IV/Pekan Baru","Alamat Jl. Kesehatan No.2, Kp. Bandar, Kec. Senapelan, Kota Pekanbaru, Riau 28155","Telepon (0761) 22426"))
                list.add(Hospital("RSU Arifin Ahmad Pekan Baru","Alamat Jl. Diponegoro No. 2, Pekanbaru","Telepon (0761) 23418 , 21618 , 21657"))
                list.add(Hospital("Tk III Pekanbaru","Alamat Jalan RA Kartini No.14, Simpang Empat, Pekanbaru Kota, Simpang Empat, Kec. Pekanbaru Kota, Kota Pekanbaru, Riau 28156","Telepon (0761) 47691"))
                list.add(Hospital("RSAU-3 DR. SUKIRMAN LANUD RSN","Alamat Jl. Adi Sucipto, Sidomulyo Tim., Kec. Marpoyan Damai, Kota Pekanbaru, Riau 28289",""))
                list.add(Hospital("RSU Puri Husada","Alamat Jl. Veteran No. 52, Hilir Tembilahan","Telepon (0768) 24563"))
            }
            "Kepulauan Riau" -> {
                list.add(Hospital("RSUD Muhammad Sani (Kab. Karimun)","Alamat Jl. Soekarno - Hatta No. 1 Tanjung Balai Karimun","Telepon (0777) 327808"))
                list.add(Hospital("RSBP Batam","Alamat Jl. Dr. Ciptomangunkusumo, Sekupang Batam","Telepon (0778) 322046 , 322121"))
                list.add(Hospital("RSUD Embung Fatimah","Alamat Jl. R. Soeprapto. Blok D 1 - 9 Batu Aji Kota Batam","Telepon (0778) 364446"))
                list.add(Hospital("RSAL-2 MIDIATO SURYATANI","Alamat Jl. Ciptadi No.1, Tanjungpinang Kota, Kota Tanjung Pinang, Kepulauan Riau","Telepon (0771) 21428"))
                list.add(Hospital("RSUD Provinsi Kep. Riau Tanjungpinang","Alamat Jl. WR Supratman No. 100, KM 8 Tanjungpinang","Telepon (0771) 7335203"))
                list.add(Hospital("RSAU-3 DR. YUNIATI WISMA RANAI","Alamat Kawasan Bandara AU, Ranai Kota, Bunguran Tim., Kabupaten Natuna, Kepulauan Riau 29783",""))
            }
            "Jambi" -> {
                list.add(Hospital("RSU Raden Mattaher Jambi","Alamat Jl. Letjen. Soeprapto No. 31, Telanaipura, Jambi","Telepon (0741) 61692 , 61694 , 63394 , 62364"))
                list.add(Hospital("Tk III Jambi","Alamat Jl. Raden Mattaher No.3, Rajawali, Jambi, Kota Jambi, Jambi 36361","Telepon (0741) 23246"))
            }
            "Bengkulu" -> {
                list.add(Hospital("RSU Arga Makmur","Alamat Jl. Siti Khadijah No.08 Arga Makmur Kab.Bengkulu Utara","Telepon (0737) 521118"))
                list.add(Hospital("RSUD Hasanuddin Damrah Manna","Alamat Jl. Raya Padang Panjang Manna, Kab.Bengkulu Utara","Telepon 085381637684"))
                list.add(Hospital("Tk III Tjtra Bengkulu","Alamat Jl. Veteran No.2, Ps. Jitra, Kec. Tlk. Segara, Kota Bengkulu, Bengkulu 38113","Telepon (0736) 21553"))
                list.add(Hospital("Rumkit Tk. IV /Bengkulu","Alamat Jl. Zainul Arifin No.27, Tim. Indah, Kec. Singaran Pati, Kota Bengkulu, Bengkulu 38225",""))
                list.add(Hospital("RSU Dr. M. Yunus Bengkulu","Alamat Jl. Bhayangkara Sidomulyo, Bengkulu","Telepon (0736) 52004 , 5111"))
            }
            "Sumatera Selatan" -> {
                list.add(Hospital("Rumkit Tk. IV/Lahat","Alamat Jalan Lintas Pagar Alam-Lahat, Pasar Baru, Kecamatan Lahat, Ps. Baru, Kec. Lahat, Kabupaten Lahat, Sumatera Selatan 31461","Telepon (0731) 326195"))
                list.add(Hospital("Rumkit Tk. IV/dr. Noesmir Baturaja","Alamat Jl. Dr. M. Hatta No.16, Baturaja Lama, Kec. Baturaja Timur, Kabupaten Ogan Komering Ulu, Sumatera Selatan 32125","Telepon (0735) 320123"))
                list.add(Hospital("RSU Kayu Agung","Alamat Jl. Letjen Yusuf Singadekane Kel. Jua-jua Kec.Kayuagung, Kab.Ogan Komering Ilir","Telepon (0712) 323889"))
                list.add(Hospital("RS Dr. Rivai Abdullah","Alamat Jl. Sungai Kundur Kelurahan Mariana Kec. Banyuasin I","Telepon (0711) 7537201"))
                list.add(Hospital("RS Muhammadiyah Palembang","Alamat Jln. Jend Ahmad Yani 13, Ulu Palembang 30263","Telp (0711) 511446"))
                list.add(Hospital("Rumkit Tk. II/dr.A K Gani","Alamat Jl. Dr. Ak. Gani No.1, 19 Ilir, Kec. Bukit Kecil, Kota Palembang, Sumatera Selatan 30113",""))
                list.add(Hospital("Balai Besar Laboratorium Kesehatan Palembang","Alamat Jl. Inspektur Yazid No.2, Sekip Jaya, Kec. Kemuning, Kota Palembang, Sumatera Selatan 30126","Telepon (0711) 352683"))
                list.add(Hospital("RSU Dr. M. Hoesin Palembang","Alamat Jl. Jend. Soedirman Km. 3.5 , Palembang 30126","Telepon (0711) 354088"))
                list.add(Hospital("Tk III Palembang","Alamat Jl. Jend. Sudirman No.km 4, RW.5, Ario Kemuning, Kec. Kemuning, Kota Palembang, Sumatera Selatan","Telepon (0711) 410023"))
                list.add(Hospital("RSUD Siti Fatimah Provinsi Sumatera Selatan","Alamat Jl. Kol. H. Burlian Km 6 Kel. Sukabangun, Kec. Sukarami, Palembang 30151","Telepon (0711) 5718883 , 5718889"))
            }
            "Kepulauan Bangka Belitung" -> {
                list.add(Hospital("RSUD Depati Hamzah","Alamat Jl. Soekarno Hatta, Kel.Bukit Besar, Ke.Girimaya Kota Pangkalpinang","Telepon (0717) 438660"))
                list.add(Hospital("RSUD Dr. H. Marsidi Judono","Alamat Jl. Jend. Sudirman Aik Rayak Km.5,5 Tanjungpandan Kab. Belitung","Telepon (0719) 22190"))
            }
            "Lampung" -> {
                list.add(Hospital("RSU Mayjend HM Ryacudu","Alamat Jl. Jend. Sudirman No. 2, Kotabumi, Lampung Utara 34511","Telepon (0724) 22095"))
                list.add(Hospital("RSUD Dr. H. Bob Bazar,SKM","Alamat Jl. Lettu Rohani No. 14B, Kalianda, Kab.Lampung Selatan","Telepon (0727) 322159"))
                list.add(Hospital("RSUD Jend. Ahmad Yani Metro","Alamat Jl. Jend. A.Yani No.13 Kota Metro Lampung","Telepon (0725) 41820"))
                list.add(Hospital("RS Muhammadiyah Metro - Lampung","Alamat Jl. Soekarno Hatta No. 42 Mulyojati 16B Metro Barat, Kota Metro","Telp (0725) 49490"))
                list.add(Hospital("Tk.III Lampung","Alamat Jl. Pramuka No.88, Rajabasa, Kec. Rajabasa, Kota Bandar Lampung, Lampung","Telepon (0721) 706402"))
                list.add(Hospital("Rumkit Tk. IV/Bandar Lampung","Alamat Jl. Dr. Rivai No.7, Penengahan, Kec. Tj. Karang Pusat, Kota Bandar Lampung, Lampung 35121","Telepon (0721) 703574"))
                list.add(Hospital("RSU Abdul Moeloek","Alamat Jl. Dr. Rivai No. 6, Tj. Karang, Lampung 35112","Telepon (0721) 703312 , 702455"))
            }
            "Banten" -> {
                list.add(Hospital("RSUD Dr. Drajat Prawiranegara","Alamat Jl. Rumah Sakit No. 1, Serang","Telepon 0254 200528"))
                list.add(Hospital("Rumkit Tk. IV/Kencana Serang","Alamat Jalan Jendral Ahmad Yani No. 21-23, Sumurpecung, Serang, Cimuncang, Kec. Serang, Kota Serang, Banten 42117","Telepon (0254) 211554"))
                list.add(Hospital("Rumkit Tk. IV Daan Mogot Tangerang","Alamat Jalan Daan Mogot No.59, Sukarasa, Kecamatan Tangerang, RT.003/RW.004, Sukarasa, Kec. Tangerang, Kota Tangerang, Banten 15111","Telepon (021) 5523551"))
                list.add(Hospital("RSU Kab Tangerang","Alamat Jl. Ahmad Yani No.9, Tangerang","Telepon (021) 5512946 , 5513709 , 5523507"))
            }
            "DKI Jakarta" -> {
                list.add(Hospital("RSUD Cengkareng","Alamat Jl. Kamal Raya Bumi Cengkareng Indah, Cengkareng Timur","Telepon (021) 54372874"))
                list.add(Hospital("Tk III Lemdiklat Polri","Alamat Jl. Ciputat Raya No.40, RT.1/RW.9, Pd. Pinang, Kec. Kby. Lama, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12310","Telepon (021) 7650384"))
                list.add(Hospital("RSUP Fatmawati","Alamat Jl. RS Fatmawati Cilandak,Jaksel","Telepon (021) 7501524"))
                list.add(Hospital("RSAL-2. MARINIR CILANDAK","Alamat Jl. Raya Cilandak Kko, RT.3/RW.5, Cilandak Tim., Kec. Ps. Minggu, Kota Jakarta Selatan, Daerah Khusus Ibukota Jakarta 12560","Telepon (021) 7805296"))
                list.add(Hospital("RSUD Pasar Minggu","Alamat Jl. TB. Simatupang No.1 Kel.Ragunan, Pasar Minggu, Jakarta Selatan","Telepon (021) 29059999"))
                list.add(Hospital("Rumkit Tk. IV/Cijantung","Alamat Mahoni No.2, RT.4/RW.6, Gedong, Kec. Ps. Rebo, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13760","Telepon (021) 8400535"))
                list.add(Hospital("Rumkit Tk. II/M Ridwan Meuraksa","Alamat Jalan Taman Mini I, RT.4/RW.2, Pinang Ranti, Makasar, RT.4/RW.2, Pinang Ranti, Kec. Makasar, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13560","Telepon (021) 22819465"))
                list.add(Hospital("Rumkit Dik Puskdikkes","Alamat Jalan Raya Bogor No.KM. 24, RT.2/RW.9, Kramat Jati, Kec. Kramat jati, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13510","Telepon (021) 8092358"))
                list.add(Hospital("Tk I R. Said Sukanto","Alamat Jl. Raya Jakarta-Bogor, RT.1/RW.5, Kramat Jati, Kec. Kramat jati, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13510","Telepon (021) 8093288"))
                list.add(Hospital("RSAU-2 DR. ESNAWAN A.","Alamat Jl. Merpati No.2, RW.11, Halim Perdana Kusumah, Kec. Makasar, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13610","Telepon (021) 8019046"))
                list.add(Hospital("RSI Jakarta Pondok Kopi","Alamat Jl. Raya Pondok Kopi , Jakarta Timur , 13460","Telp (021) 29809000 , 8630654"))
                list.add(Hospital("Balai Teknik Kesehatan Lingkungan dan Pengendalian","Alamat Jl. Balai Rakyat No.2, RT.12/RW.1, Cakung Tim., Kec. Cakung, Kota Jakarta Timur, Daerah Khusus Ibukota Jakarta 13910","Telepon (021) 46824247"))
                list.add(Hospital("RSAL-2 dr MINTOHARDJO","Alamat Jl. Bendungan Hilir 17 Jakpus","Telepon (021) 5703081"))
                list.add(Hospital("RSU Persahabatan","Alamat Jl. Persahabatan Raya","Telepon 021 489 1708"))
                list.add(Hospital("Lembaga Biologi Molekuler Eijkman","Alamat Jl. Pangeran Diponegoro No.69, RW.5, Kenari, Kec. Senen, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10430","Telepon (021) 3917131"))
                list.add(Hospital("Fakultas Kedokteran Universitas Indonesia","Alamat Jl. Salemba Raya No.6, RW.5, Kenari, Kec. Senen, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10430","Telepon (021) 3160493"))
                list.add(Hospital("Balai Besar Laboratorium Kesehatan Jakarta","Alamat Jl. Percetakan Negara No.23 B, Johar Baru, Kec. Johar Baru, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10560","Telepon (021) 4212524"))
                list.add(Hospital("Laboraturium Kesehatan DKI Jakarta","Alamat Jl. Rawasari Timur V, RT.16/RW.2, Cemp. Putih Tim., Kec. Cemp. Putih, Kota Jakarta Pusat, Daerah Khusus Ibukota Jakarta 10510","Telepon (021) 4247404"))
                list.add(Hospital("RSPAD Gatot Subroto","Alamat Jl. Dr.A. Rahman Saleh No. 24, Jakpus","Telepon (021) 3440693"))
                list.add(Hospital("RSI Jakarta Cempaka Putih","Alamat Jl. Cempaka Putih Tengah I No.1, Kel. Cempaka Putih Timur, Kec. Cempaka Putih, Kota Jakarta Pusat, DKI Jakarta 10510","Telp (021) 42801567"))
                list.add(Hospital("RSPI Dr. Sulianti Saroso","Alamat Jl. Baru Sunter Permai Raya, Jakarta 14340","Telepon 021 6506559, Fax: 021 6401411"))
            }
            "Jawa Barat" -> {
                list.add(Hospital("Tk III Brimob Kelapa Dua","Alamat Jl. Komjen.Pol.M.Jasin Jl. Klp. Dua Raya, Pasir Gn. Sel., Kec. Cimanggis, Kota Depok, Jawa Barat 16451","Telepon (021) 87704691"))
                list.add(Hospital("RSAU-3 DR. HASAN TOTO ATS","Alamat Jalan Sarjio No. 1, Atang Senjaya, Kemang, Atang Senjaya, Kec. Kemang, Bogor, Jawa Barat 16310","Telepon (0251) 7535976"))
                list.add(Hospital("Rumkit Tk. IV/Salak Bogor","Alamat Jl. Jend. Sudirman No.8, Sempur, Kecamatan Bogor Tengah, Kota Bogor, Jawa Barat 16121","Telepon (0251) 8345222"))
                list.add(Hospital("RS Paru Dr. M. Goenawan Partowidigdo","Alamat Jl. Raya Puncak KM.83, Po Box 28 Cisarua Bogor","Telepon (0251) 8253630 Fax (0251) 8257662"))
                list.add(Hospital("Tk III Setukpa","Alamat Jl Aminta Azmali Trip No.59A, Sriwidari, Kec. Gunungpuyuh, Kota Sukabumi, Jawa Barat 43121","Telepon (0266) 226262"))
                list.add(Hospital("RSUD R. Syamsudin, SH Kota Sukabumi","Alamat Jl. Rumah Sakit No.1 Kota Sukabumi","Telepon (0266) 225180 , 225181"))
                list.add(Hospital("RSAU-4 DR. HOEDIONO LANUD SDM","Alamat Jl. Pangkalan TNI AU, Suryadarma, Kalijati, Kalijati Barat, Kalijati, Kalijati Bar., Kec. Kalijati, Kabupaten Subang, Jawa Barat 41271",""))
                list.add(Hospital("Tk III Indramayu","Alamat JL. Losarang Raya, KM. 73-75, Losarang, Krimun, Indramayu, Krimun, Kec. Losarang, Kabupaten Indramayu, Jawa Barat 45253","Telepon (0234) 507877"))
                list.add(Hospital("RSU Indramayu","Alamat Jl. Murah Nara No.7 Sindang, Indramayu","Telepon 0234 272655"))
                list.add(Hospital("Rumkit Tk. III/Ciremai Cirebon","Alamat Jl. Kesambi No.237, Drajat, Kec. Kesambi, Kota Cirebon, Jawa Barat 45133","Telepon (0231) 238335"))
                list.add(Hospital("RSU Gunung Jati","Alamat JL. Kosamabi No. 56, Kota Cirebon",""))
                list.add(Hospital("Rumkit Tk. IV/Guntur Garut","Alamat Jl. Bratayuda No.101, Kota Kulon, Kec. Garut Kota, Kabupaten Garut, Jawa Barat 44112","Telepon (0262) 232325"))
                list.add(Hospital("RSU Dr. Slamet Garut","Alamat Jl. Rumah Sakit No.12 Kec.Tarogong Kidul, Kab.Garut 44151","Telepon 0262 232720"))
                list.add(Hospital("Rumkit Tk. II/Dustira Cimahi","Alamat Cimahi, Baros, Kec. Cimahi Tengah, Kota Cimahi, Jawa Barat 40521",""))
                list.add(Hospital("RSAU-4 DR. N. LUBIS LANUD SULAIMAN","Alamat Jl. Terusan Kopo-Soreang No.461, Sulaiman, Kec. Margahayu, Bandung, Jawa Barat 40229",""))
                list.add(Hospital("Tk II Bandung","Alamat Jl. Moh. Toha No.369, Ciseureuh, Kec. Regol, Kota Bandung, Jawa Barat 40256","Telepon 0811-2232-056"))
                list.add(Hospital("Rumkit Tk. IV/Sariningsih Bandung","Alamat Jl. L. L. R.E. Martadinata No.9, Citarum, Kec. Bandung Wetan, Kota Bandung, Jawa Barat 40115","Telepon (022) 4211650"))
                list.add(Hospital("RSU Hasan Sadikin Bandung","Alamat Jl. Pasteur No. 38, Bandung","Telepon (022) 2034953-55"))
                list.add(Hospital("RSTP Dr. H.A. Rotinsulu Bandung","Alamat Jl. Bukit Jarian No. 40, Bandung","Telepon (022) 3034446"))
                list.add(Hospital("RSAU-2 DR. M. SALAMUN","Alamat Jl. Ciumbuleuit No.203, Ciumbuleuit, Kec. Cidadap, Kota Bandung, Jawa Barat 40142","Telepon (022) 2032090"))
            }
        }

        return list
    }
}