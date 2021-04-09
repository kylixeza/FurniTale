package com.raion.furnitale.core.data.source.remote.network

import com.raion.furnitale.core.data.source.remote.response.ProductResponse

class DummyApiService {

    private fun getAllProductsList(): List<ProductResponse> {
        val listProducts = ArrayList<ProductResponse>()

        listProducts.add(
            ProductResponse(
                "",
                0,
                "Modern Chair",
                "Cheap, Aesthetic, and Elegant for your living room",
                "https://user-images.githubusercontent.com/81003299/113378675-c475bc00-93a1-11eb-8d07-bc6198c1bdd9.png",
                "https://user-images.githubusercontent.com/81003299/113385048-81bbe000-93b1-11eb-9847-5d301b81c4ae.png",
                "Living Room",
                "Rp 133.000,-",
                133000,
                "Adi Jaya",
                "Malang",
                "Brand: Olympic\nDimensi: (P) 51 x (L) 46 x (T) 82 cm\nMaterial: plastik, kaki kayu\nWarna: putih, hitam, merah, biru, hijau, kuning"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                1,
                "Lampu Plafon Led",
                "Lampu Plafon Led Modern 220v 18w Untuk Dapur / Ruang Tamu",
                "https://user-images.githubusercontent.com/81003299/113378436-37326780-93a1-11eb-8708-317c9173d61d.png",
                "https://user-images.githubusercontent.com/81003299/113385052-8385a380-93b1-11eb-859a-c7750e1fc3d3.png",
                "Living Room",
                "Rp 200.000,-",
                200000,
                "inglighting188.id",
                "Luar Negri",
                " Brand Name : ING\nIs Bulbs Included : No\nOrigin : CN(Origin)\nNumber of light sources : 5"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                2,
                "Karpet Bulu",
                "Karpet Bulu Matras Bulu Rasfur Tebal 2,5 CM Polos Murah",
                "https://user-images.githubusercontent.com/81003299/113378306-d9058480-93a0-11eb-84e7-811d36141f8f.png",
                "https://user-images.githubusercontent.com/81003299/113385049-82547680-93b1-11eb-8b39-6af64f48c35c.png",
                "Living Room",
                "Rp 87.000,-",
                87000,
                "gudangwks01",
                "Malang",
                "Karpet bulu rasfur lembut dan halus aman untuk anak-anak\nKarpet ini bisa di pakai untuk,ambal meja,ambal kursi, di gelar di ruang tamu atau depan tv agar ruangan lebih bagus dan cantik dan bisa di jadikan untuk kado/hadiah dll"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                3,
                "Rak Susun Serbaguna",
                "Rak Serbaguna Rak Dinding Dekorasi Ruang Tamu 3 Tingkat",
                "https://user-images.githubusercontent.com/81003299/113385337-23dbc800-93b2-11eb-9161-513482b8716c.png",
                "https://user-images.githubusercontent.com/81003299/113385043-7ff21c80-93b1-11eb-8410-9cb24faf602b.png",
                "Living Room",
                "Rp 52.000,-",
                52000,
                "rmstore1",
                "Surabaya",
                "Rak kayu gantung susun 3 dengan tali untuk penyimpanan/penataan barang. Untuk menyimpan perlengkapan dapur,perlengkapan mandi dan juga sebagai rak hias/dekorasi untuk mempercantik ruang serta rumah anda."
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                4,
                "Meja Minimalis",
                "MEJA RUANG TAMU MINIMALIS KAKI KAYU RETRO MURAH",
                "https://user-images.githubusercontent.com/81003299/113378551-811b4d80-93a1-11eb-980e-1b714cb719f8.png",
                "https://user-images.githubusercontent.com/81003299/113385045-81bbe000-93b1-11eb-839f-255d23f44ab2.png",
                "Living Room",
                "Rp 495.000,-",
                495000,
                "kristianiwinda98",
                "KAB.Gresik",
                "* Bahan kaki : kayu mahoni\n* DIKIRIM DALAM KEADAAN BELUM DI RAKIT (DIY/RAKIT SENDIRI)\n* ADA PETUNJUK PEMASANGAN\nUKURAN :\nP x L x T\n90cm x 40cm x 40cm"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                5,
                "Kasur Comforta",
                "Comforta Superfit SC Vulcan Set 200x200",
                "https://user-images.githubusercontent.com/81003299/113378766-fc7cff00-93a1-11eb-90fa-48dc69cb9cb8.png",
                "https://user-images.githubusercontent.com/81003299/113385050-82547680-93b1-11eb-87f9-56755fc2b51f.png",
                "Bedroom",
                "Rp 4.399.000,-",
                4399000,
                "sleep.center",
                "Jakarta Barat",
                " SUPERFIT  VULCAN\n\n Spesifikasi :\n• Couple Comfort Spring : pegas yg disusun secara vertikal untuk meredam guncangan" +
                        "\n• Double Guard : Rangkaian kawat baja untuk memperkuat setiap sisi kasur" +
                        "\n• Extra Plush : Lapisan busa ekstra empuk untuk kenyamanan saat tidur" +
                        "\n • Euro Top : Lapisan multi layers untuk kesempurnaan feel kasur" +
                        "\n Feel            : Empuk\nTinggi          : 28 cm\nGaransi per     : 10 tahun\n   Free\t: 2 bantal dan 2 guling"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                6,
                "Lemari Baju Portable",
                "SIMPLE CLOTH RACK / RAK BAJU LEMARI PORTABLE",
                "https://user-images.githubusercontent.com/81003299/113378960-7ad9a100-93a2-11eb-8de7-2942f9056246.png",
                "https://user-images.githubusercontent.com/81003299/113385043-7ff21c80-93b1-11eb-8410-9cb24faf602b.png",
                "Bedroom",
                "Rp 105.000,-",
                105000,
                "buynow.id",
                "KAB.Karimun",
                "BAHAN : KAIN + BESI\n\n " +
                        "KELEBIHAN CLOTH RACK NEW MODEL :" +
                        "\n1. Menyimpan dengan rapi dan terhindar dari debu DLL" +
                        "\n2. MULTIFUNGSI, bAWAH rak sepatu, ATAS rak baju, tas ataupun keperluan menyimpan barang lainnya." +
                        "\n3. Hemat tempat, dengan material berkualitas tinggi sehingga awet dipakai" +
                        "\n4. Dengan tiang besi yg kokoh, connector yg kuat dan MATERIAL Non-Woven yang ramah lingkungan" +
                        "\n5. EASY -TO - BUILD(mudah dipasang) dan dibongkar, portable dan ringan" +
                        "\n6. Dengan warna yg fashionable" +
                        "\n7. Bisa menyimpan BAJU,HANDUK,SEPATU DLL" +
                        "\n8. Penutup menggunakan resleting sehingga lebih rapat dan bagus"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                7,
                "Set Kamar Tidur Mewah",
                "Set Kamar Tidur Mewah Mebel Meubel Furniture Asli Jepara",
                "https://user-images.githubusercontent.com/81003299/113379142-e754a000-93a2-11eb-90c1-83857b007be0.png",
                "https://user-images.githubusercontent.com/81003299/113385044-81234980-93b1-11eb-8bd6-0b9996ec21de.png",
                "Bedroom",
                "Rp 29.999.000,-",
                29999000,
                "zaenal_groceline",
                "KAB.Jepara",
        "Harga tersebut belum termasuk ongkir produk (berat/ongkir yang tertera di aplikasi hanya untuk mengirim invoice/nota).. " +
                "\nUntuk Info ongkir produk mohon chat kami terlebih dahulu.. " +
                "\nHati-hati, jangan tergiur dg harga yg murah tetapi kualitas blm jelas " +
                "\nKarena utk produk kerajinan sperti mebel jepara, setiap penjual memiliki standar kualitas yg berbeda-beda. tdk sperti mobil/motor baru, walaupun berbeda dealer tetapi kualitas tetap sama")
        )

        listProducts.add(
            ProductResponse(
                "",
                8,
                "Rak Kamar Tidur",
                "Rak Penyimpanan Serbaguna Dapat Dilepas Pasang 4 tingkat",
                "https://user-images.githubusercontent.com/81003299/113379067-bc6a4c00-93a2-11eb-8e68-ff3ad3eb039f.png",
                "https://user-images.githubusercontent.com/81003299/113385053-8385a380-93b1-11eb-8844-5daeea6e4fc7.png",
                "Bedroom",
                "Rp 99.000,-",
                99000,
                "sun_homeware",
                "Jakarta Barat",
                "Rak Penyimpanan 4 Tingkat ini adalah solusi untuk menata barang secara rapi dalam satu tempat. " +
                        "\nRak ini terbuat dari material berkualitas yang kuat, tahan lama dan mudah disusun. " +
                        "\nMulai dari koleksi buku kesayangan, peralatan masak hingga mainan anak dapat disimpan di rak ini. " +
                        "\nPraktis, serbaguna dan hemat tempat. " +
                        "\nUkuran PXLXT" +
                        "\n35,5 Cm X 24 Cm X 100,5 Cm"

            )
        )

        listProducts.add(
            ProductResponse(
                "",
                9,
                "ING Lampu Plafon Led Gaya Nordic",
                "Lampu Plafon Led Gaya Nordic Modern Bahan Besi + Kayu Untuk Dekorasi Ruang Tamu / Kamar Tidur",
                "https://user-images.githubusercontent.com/81003299/113378824-26cebc80-93a2-11eb-9391-30fed023121e.png",
                "https://user-images.githubusercontent.com/81003299/113385053-8385a380-93b1-11eb-8844-5daeea6e4fc7.png",
                "Bedroom",
                "Rp 228.000,-",
                228000,
                "inglighting188.id",
                "Luar Negri",
                "Brand Name :ING " +
                        "\nIs Bulbs Included : No " +
                        "\nBody Material : iron " +
                        "\nFinish : iron " +
                        "\nLighting Area : 5-10square meters " +
                        "\nVoltage : 90-260V"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                10,
                "Wastafel Perlengkapan Dapur",
                "Wastafel Perlengkapan Dapur Unik Paling Murah",
                "https://user-images.githubusercontent.com/81003299/113379539-ff78ef00-93a3-11eb-96f4-d7238ef948c7.png",
                "https://user-images.githubusercontent.com/81003299/113385053-8385a380-93b1-11eb-8844-5daeea6e4fc7.png",
                "Kitchen",
                "Rp 24.500,-",
                24500,
                "tuenti.id",
                "Tangerang",
                "DETAIL PRODUK " +
                        "\n- Ukuran Produk : 39.5 x 8.5 x 27 cm " +
                        "\n- Material Bahan : Plastik " +
                        "\n- Paket yang di dapatkan : 1pcs Rak Sabun Cuci Piring Gantung"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                11,
                "Olla Hom Rak Lantai Beroda",
                "Rak Penyimpanan Rak Dapur Serbaguna jaring 5 Susun",
                "https://user-images.githubusercontent.com/81003299/113379449-b88af980-93a3-11eb-9315-d8ed81156f23.png",
                "https://user-images.githubusercontent.com/81003299/113385052-8385a380-93b1-11eb-859a-c7750e1fc3d3.png",
                "Kitchen",
                "Rp 299.000,-",
                299000,
                "Ollahom",
                "Tangerang",
                " Rak Beroda 5 Susun " +
                        "\nKuat dan kokoh, dilengkapi pelindung 4 sisi untuk mencegah barang jatuh " +
                        "\nDilengkapi dengan gantungan yang dapat dipindahkan " +
                        "\nKapasitas penyimpanan besar " +
                        "\nDilengkapi 4 buah roda yang memudahkan untuk berpindah " +
                        "\nDilengkapi rem pada roda agar mencegah rak bergerak " +
                        "\nCocok untuk di ruang tamu, dapur, ruang belajar, kamar, salon, dan lain lain. " +
                        "\ndimensi : 44cm x 34cm x 105cm"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                12,
                "Keset Dapur Kulit Premium",
                "Keset Dapur Kulit Premium Elegant Bahan PVC Anti Minyak dan Tahan Air (1 SET DAPAT 2PCS) 45x120cm",
                "https://user-images.githubusercontent.com/81003299/113379290-49150a00-93a3-11eb-9280-0eedd29fa094.png",
                "https://user-images.githubusercontent.com/81003299/113385051-82ed0d00-93b1-11eb-9521-9addc0b9ee84.png",
                "Kitchen",
                "Rp 118.000,-",
                118000,
                "kerajaankarpet",
                "Tangerang",
                "INGIN DAPUR BUNDA TERLIHAT RAPI  DAN MEWAH? MILIKI SEGERA KESET DAPUR MODERN  PREMIUM ELEGANT BAHAN PVC KULIT\n\n " +
                        "\n* Dapat Menyerap air dan minyak, selalu melindungi dapur Anda dari kelembaban dan noda. " +
                        "\n* anti slip  PVC, gambar anti luntur , tahan lama. menyerap air dan anti minyak dan 100% tidak licin. pembersihan sangat mudah hanya menggunakan kain lap , tidak perlu repot-repot dicuci " +
                        "\n* Bahan:   PVC " +
                        "\n* Ketebalan:   5mm"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                13,
                "Meja Makan Kursi 4 Rotan",
                "[FREE ONGKIR] Meja Makan Kursi 4 Rotan Sintetis Furniture Original High Quality",
                "https://user-images.githubusercontent.com/81003299/113379482-d8bab880-93a3-11eb-82b2-35643aa42fcf.png",
                "https://user-images.githubusercontent.com/81003299/113385045-81bbe000-93b1-11eb-839f-255d23f44ab2.png",
                "Kitchen",
                "Rp 1.499.000,-",
                1499000,
                "galleryrotan77",
                "Jakarta Timur",
                "Barang ada yang READY STOK dan PRE ORDER Warna Bisa Request Bebas. " +
                        "\nJika orderan sedang ramai, silahkan antri sesuai pesanan. Kami anyam dengan rapih, tidak terlalu cepat tapi rapih tidak terburu buru. " +
                        "\nSpesifikasi barang selengkapnya bisa chat kami atau comment."
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                14,
                "Meja + Kompor Gas",
                "Meja Kompor Gas Stainless jos gandos",
                "https://user-images.githubusercontent.com/81003299/113379366-811c4d00-93a3-11eb-86b3-97e1addc84fa.png",
                "https://user-images.githubusercontent.com/81003299/113385044-81234980-93b1-11eb-8bd6-0b9996ec21de.png",
                "Kitchen",
                "Rp 475.000,-",
                475000,
                "penjual.kompor",
                "Semarang",
                "Spesifikasi: " +
                        "\nPANJANG = 85 CM " +
                        "\nLEBAR = 50,5 CM " +
                        "\nTINGGI = 82 CM " +
                        "\nLANGSUNG DARI PABRIK"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                15,
                "Rak Kamar Mandi Sudut Tempel",
                "Greenland Rak kamar Mandi Sudut Siku Tempel Keramik Tempat Penyimpanan Sabun Odol HRD308",
                "https://user-images.githubusercontent.com/81003299/113379702-639bb300-93a4-11eb-85b8-fd4fe571c56f.png",
                "https://user-images.githubusercontent.com/81003299/113385054-841e3a00-93b1-11eb-9c96-29ff6790513d.png",
                "Bathroom",
                "Rp 11.500,-",
                11500,
                "greenland.co.id",
                "Jakarta Barat",
                "BRAND PXTON: " +
                        "\n- BAHAN PLASTIK BARU " +
                        "\n- WARNA CERAH"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                16,
                "Krisbow Soap Dispenser",
                "Tempat sabun mandi cair 380 ml",
                "https://user-images.githubusercontent.com/81003299/113379836-cc832b00-93a4-11eb-92fc-cc8342ad5c1d.png",
                "https://user-images.githubusercontent.com/81003299/113385049-82547680-93b1-11eb-8b39-6af64f48c35c.png",
                "Bathroom",
                "Rp 98.000,-",
                98000,
                "krisbow",
                "Bekasi",
                "Gunakan Dispenser Sabun Cair dari Krisbow ini untuk menyimpan sabun cair mandi Anda. Tempelkan dispenser sabun pada dinding kamar mandi di dekat area mandi ataupun wastafel sehingga mudah dijangkau dan digunakan. Dengan Dispenser Sabun ini maka sabun cair akan lebih higienis ketika digunakan"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                17,
                "Bathtub Kamar Mandi",
                "BATHTUB KAMAR MANDI FIBERGLASS MODEL: MICHAEL ANGELO 170x74x47 free packing kayu",
                "https://user-images.githubusercontent.com/81003299/113379629-351dd800-93a4-11eb-9943-37c7a51f8a2d.png",
                "https://user-images.githubusercontent.com/81003299/113385045-81bbe000-93b1-11eb-839f-255d23f44ab2.png",
                "Bathroom",
                "Rp 2.000.000,-",
                2000000,
                "maumandi.co",
                "Surabaya",
                "-BAHAN FIBERGLASS " +
                        "\n-HARGA SUDAH TERMASUK PACKING KAYU (TIDAK ADA BIAYA PACKING) " +
                        "\n-MODEL KEKINIAN MEMBUAT KAMAR MANDI ANDA TERKESAN MEWAH " +
                        "\n-BELUM TERMASUK AFUR/ SALURAN PEMBUANGAN AIR " +
                        "\n-PENGERJAAN RAPIH " +
                        "\n-SERAT FIBERGLASS."
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                18,
                "Shower Modern Masa Kini",
                "Shower masa kini dengan 4 tombol saluran air bisa untuk air panas dan dingin",
                "https://user-images.githubusercontent.com/81003299/113379740-84fc9f00-93a4-11eb-96c2-ce0a8600c2fb.png",
                "https://user-images.githubusercontent.com/81003299/113385048-81bbe000-93b1-11eb-9847-5d301b81c4ae.png",
                "Bathroom",
                "Rp 1.650.000,-",
                1650000,
                "ryandaffastore.id",
                "Luar Negri",
                "Kategori produk: shower/shower " +
                        "\nSpesies: top spray " +
                        "\nFungsi: hujan " +
                        "\nBahan: stainless steel " +
                        "\nGearbox: dinding" +
                        "\nModel : 010"
            )
        )


        listProducts.add(
            ProductResponse(
                "",
                19,
                "Rak Handuk Dinding Toilet Aluminium",
                "Rak Handuk Dinding Toilet Aluminium Towel Soap Shampoo Bathroom Sabun Busa Kamar mandi multifungsi",
                "https://user-images.githubusercontent.com/81003299/113379912-094f2200-93a5-11eb-864a-763e7175b605.png",
                "https://user-images.githubusercontent.com/81003299/113385051-82ed0d00-93b1-11eb-9521-9addc0b9ee84.png",
                "Bathroom",
                "Rp 53.000,-",
                53000,
                "gamaumandi.co",
                "Surabaya",
                "Rak multifungsi dinding toilet aluminium dengan kualitas high-end , nyaman , tahan lama. " +
                        "\nFitur terbesar adalah penyimpanan dan kuat , tidak lagi perlu khawatir tentang tidak ada tempat untuk meletakkan peralatan dan khawatir   tentang karat . " +
                        "Ukuran 58 x 21 x 15 CM"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                20,
                "Tenda Camping / Tenda Gunung",
                "Tenda Camping Tenda Gunung 2-3 Orang Portable SPEEDS",
                "https://user-images.githubusercontent.com/81003299/113376136-3a2a5980-939b-11eb-9781-324256e5c860.PNG",
                "https://user-images.githubusercontent.com/81003299/113385052-8385a380-93b1-11eb-859a-c7750e1fc3d3.png",
                "Outdoor",
                "Rp 162.000,-",
                162000,
                "ahlialam",
                "Surabaya",
                "Tenda Camping yang cocok untuk kegiatan outdoor, hiking, kegiatan camping, piknik. " +
                        "\nTenda Camping ini dapat digunakan untuk 2-3 Orang. " +
                        "\nTenda Camping ini juga dilengkapi dengan kelambu anti nyamuk sehingga terhindar dari nyamuk atau serangga yang terbuat dari bahan material polyester yang berkualitas. " +
                        "\nTahan terhadap air hujan dan cuaca panas. " +
                        "\n\nMemiliki ukuran: 160x210 cm " +
                        "\nMemiliki satu pintu " +
                        "\nDilengkapi dengan frame, pasak penutup atas dan tas"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                21,
                "Paket Alat Masak Cooking Set",
                "Paket Alat Masak Cooking Set dan plus Kompor Camping Nesting DS SY 200 Outdoor Nasting",
                "https://user-images.githubusercontent.com/81003299/113376254-765dba00-939b-11eb-9811-126c8bb4f052.png",
                "https://user-images.githubusercontent.com/81003299/113385050-82547680-93b1-11eb-87f9-56755fc2b51f.png",
                "Outdoor",
                "Rp 144.000,-",
                144000,
                "outdoorindo",
                "Jakarta Selatan",
                "Isi Paket Kompor : " +
                        "\n- Kompor Portable " +
                        "\n- Tas Kompor " +
                        "\n\nCooking set 1-2 person DS SY 200 " +
                        "\nfrying pan 1 : 145 x 40 mm " +
                        "\npanci 1 : 135 x 75 mm " +
                        "\nmangkok kecil 2 pcs " +
                        "\ncentong sayur 1 pcs " +
                        "\nsendok nasi 1 pcs " +
                        "\nspons untuk mencuci 1 pcs"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                22,
                "Soleil Kursi Outdoor",
                "ACE HARDWARE - Soleil Kursi Outdoor & Ottoman Deluxe/ Set/ Set Meja Dan Kursi/ Furnitur Outdoor",
                "https://user-images.githubusercontent.com/81003299/113377275-0e5ca300-939e-11eb-8520-78f1dad6feab.png",
                "https://user-images.githubusercontent.com/81003299/113385050-82547680-93b1-11eb-87f9-56755fc2b51f.png",
                "Outdoor",
                "Rp 2.499.000,-",
                2499000,
                "outdoorindo",
                "Jakarta Selatan",
                "Detail Produk & Spesifikasi " +
                        "\nDilengkapi ottoman " +
                        "\nDimensi produk kursi : 72 x 80 x 95 cm " +
                        "\nDimensi produk Ottoman :" +
                        "\n41 x 42 x 37 cm " +
                        "\nMaterial : steel, polyester " +
                        "\nFinishing : powder coating"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                23,
                "Ayunan GANTUNG ROTAN SINTETIS",
                "Ayunan GANTUNG ROTAN SINTETIS JUMBO (diameter130)",
                "https://user-images.githubusercontent.com/81003299/113377485-9a6eca80-939e-11eb-9690-45c8bc57506d.png",
                "https://user-images.githubusercontent.com/81003299/113385044-81234980-93b1-11eb-8bd6-0b9996ec21de.png",
                "Outdoor",
                "Rp 1.499.000,-",
                1499000,
                "Teguhwow",
                "KAB.Cirebon",
                "TIDAK TERMASUK ONGKIR!! " +
                        "\nBeban maks 150kg"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                24,
                "Gazebo Glugu Kayu Kelapa",
                "Promo murah SAUNG GAZEBO GLUGU KAYU KLAPA (pasang)",
                "https://user-images.githubusercontent.com/81003299/113377609-fdf8f800-939e-11eb-9b0e-8483ffb0fb59.png",
                "https://user-images.githubusercontent.com/81003299/113385048-81bbe000-93b1-11eb-9847-5d301b81c4ae.png",
                "Outdoor",
                "Rp 3.175.000,-",
                3175000,
                "gazebomaster",
                "KAB.Jepara",
                "KAMI MENERIMA PESANAN COSTOM PRODUK MEBEL FURNITURE ASLI JEPARA SESUAI KEINGINAN ANDA. " +
                        "\nFINISHING: NATURAL MELAMINE, GOLD, SILVER, MARMER, DLL ( REQUEST) " +
                        "\nKAIN JOK: BLUDRU,  OSCAR DLL (REQUEST) " +
                        "\nWARNA KAIN SESUAI KEINGINAN " +
                        "\nharga tercantum sudah termasuk finishing + jok dan packing barang singleface dan kardus/ seperti di gambar"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                25,
                "Rhyme stoneware tea strainer",
                "Rhyme stoneware ancient altar tea strainer tea filter mesh",
                "https://user-images.githubusercontent.com/81003299/113383653-977bd600-93ae-11eb-84cd-c54f48aaaf9b.png",
                "https://user-images.githubusercontent.com/81003299/113385051-82ed0d00-93b1-11eb-9521-9addc0b9ee84.png",
                "Accessories",
                "Rp 414.000,-",
                414000,
                "scky0.id",
                "Luar Negri",
                "Material: Pottery"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                26,
                "Yi Lu Ping An",
                "Desain Aksesoris Dekorasi",
                "https://user-images.githubusercontent.com/81003299/113383971-39032780-93af-11eb-87e9-6429347b12e4.png",
                "https://user-images.githubusercontent.com/81003299/113385054-841e3a00-93b1-11eb-9c96-29ff6790513d.png",
                "Accessories",
                "Rp 1.350.000",
                1350000,
                "FZ001.id",
                "Luar Negri",
                "Model：Tembaga Yi Lu Ping An Dekorasi " +
                        "\nFungsi：Keamanan dan Perdamaian"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                27,
                "European-style small ornaments",
                "European-style small ornaments, wine cabinets, accessories, desk porch shelf, home living room model room, stylish and simple furnishings",
                "https://user-images.githubusercontent.com/81003299/113384195-bb8be700-93af-11eb-90af-a12a8bc3cb8e.png",
                "https://user-images.githubusercontent.com/81003299/113385049-82547680-93b1-11eb-8b39-6af64f48c35c.png",
                "Accessories",
                "Rp 1.300.000,-",
                1300000,
                "scky001.id",
                "Luar Negri",
                "Function: Home Decoration " +
                        "\nMaterial: Resin " +
                        "\nStyle: European"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                28,
                "Aksesoris Pasangan Lampu Romantis",
                "Aksesoris Pasangan Kreatif Praktis Untuk Dekorasi Kamar Tidur",
                "https://user-images.githubusercontent.com/81003299/113384443-3b19b600-93b0-11eb-875f-07a2ed1a1fb4.png",
                "https://user-images.githubusercontent.com/81003299/113385054-841e3a00-93b1-11eb-9c96-29ff6790513d.png",
                "Accessories",
                "Rp 1.700.000,-",
                1700000,
                "scky4.id",
                "Luar Negri",
                "Function: Luminous " +
                        "\nMaterial: Resin " +
                        "\nStyle: Simple and Modern"
            )
        )

        listProducts.add(
            ProductResponse(
                "",
                29,
                "Aksesoris Ukiran Kayu Motif Bunga",
                "10 Pcs Aksesoris Ukiran Kayu Motif Bunga Gaya Eropa Untuk Sudut Furnitur",
                "https://user-images.githubusercontent.com/81003299/113384572-8df36d80-93b0-11eb-87b7-7295c49173cf.png",
                "https://user-images.githubusercontent.com/81003299/113385043-7ff21c80-93b1-11eb-8410-9cb24faf602b.png",
                "Accessories",
                "Rp 150.000,-",
                150000,
                "luckygirl3.id",
                "KAB.Jepara",
                "Exquisite carved wooden flower patterns look classical and elegant. Create a beautiful and elegant European style for your home. " +
                        "\nMade of rubber wood, natural, environmental-friendly, safe and durable to use. " +
                        "\n\nSpecifications: " +
                        "\nMaterial: Rubber Wood " +
                        "\nColor: Wood Color " +
                        "\nType: C-37 " +
                        "\nSize: (Approx) 10x10cm " +
                        "\nPackage Included:" +
                        "\n10 PCs x Wood Applique"
            )
        )
        return listProducts
    }

    fun getLivingRoomList(): List<ProductResponse> {
        val listLivingRoom = ArrayList<ProductResponse>()
        for (index in 0..4) {
            listLivingRoom.add(
                getAllProductsList()[index]
            )
        }
        return listLivingRoom
    }

    fun getBedRoomList(): List<ProductResponse> {
        val listBedRoom = ArrayList<ProductResponse>()
        for (index in 5..9) {
            listBedRoom.add(
                getAllProductsList()[index]
            )
        }
        return listBedRoom
    }

    fun getKitchenList(): List<ProductResponse> {
        val listKitchen = ArrayList<ProductResponse>()
        for (index in 10..14) {
            listKitchen.add(
                getAllProductsList()[index]
            )
        }
        return listKitchen
    }

    fun getBathroomList(): List<ProductResponse> {
        val listBathRoom = ArrayList<ProductResponse>()
        for (index in 15..19) {
            listBathRoom.add(
                getAllProductsList()[index]
            )
        }
        return listBathRoom
    }

    fun getOutdoorList(): List<ProductResponse> {
        val listOutdoor = ArrayList<ProductResponse>()
        for (index in 20..24) {
            listOutdoor.add(
                getAllProductsList()[index]
            )
        }
        return listOutdoor
    }

    fun getAccessoriesList(): List<ProductResponse> {
        val listAccessories = ArrayList<ProductResponse>()
        for (index in 25..29) {
            listAccessories.add(
                getAllProductsList()[index]
            )
        }
        return listAccessories
    }

    fun getProductDetail(id: Int): ProductResponse = getAllProductsList()[id]

    fun getProductSelection(): List<ProductResponse> {
        val listSelection = ArrayList<ProductResponse>()
        for (index in 0 until 10 step 2) {
            listSelection.add(
                getAllProductsList()[index]
            )
        }
        return listSelection
    }

    fun getNewProduct(): List<ProductResponse> {
        val listNewProduct = ArrayList<ProductResponse>()
        for (index in 0 until 30 step 5) {
            listNewProduct.add(
                getAllProductsList()[index]
            )
        }
        return listNewProduct
    }

    fun getAllDiscount(): List<String> {
        val listDiscount = ArrayList<String>()
        listDiscount.apply {
            add("https://user-images.githubusercontent.com/58837451/114007679-bf29dd00-988b-11eb-9a4f-2481bf255de3.png")
            add("https://user-images.githubusercontent.com/58837451/114007686-bfc27380-988b-11eb-846c-0564f46cfe31.png")
            add("https://user-images.githubusercontent.com/58837451/114007696-c0f3a080-988b-11eb-9629-c34608e425f3.png")
        }
        return listDiscount
    }

    fun getAllCategoryImage(): List<String> {
        val listCategory = ArrayList<String>()
        listCategory.apply {
            add("https://user-images.githubusercontent.com/81003299/114211252-96d4d800-998a-11eb-9ce6-1b57250cdec8.png")
            add("https://user-images.githubusercontent.com/81003299/114211253-976d6e80-998a-11eb-8897-502fc9c7e5dc.png")
            add("https://user-images.githubusercontent.com/81003299/114211238-94727e00-998a-11eb-874c-02451206df14.png")
            add("https://user-images.githubusercontent.com/81003299/114211243-95a3ab00-998a-11eb-9ada-a3c7b0e29d27.png")
            add("https://user-images.githubusercontent.com/81003299/114211246-963c4180-998a-11eb-9f7a-3777bd64881a.png")
            add("https://user-images.githubusercontent.com/81003299/114211249-96d4d800-998a-11eb-9a14-0f4e30e4d934.png")
        }
        return listCategory
    }
}