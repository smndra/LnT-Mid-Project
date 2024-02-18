package Main;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Comparator;

import Menu.Karyawan;

public class Main {
	Scanner scan = new Scanner(System.in);
	
	ArrayList<Karyawan> dataKaryawan = new ArrayList<Karyawan>();
	ArrayList<String> dataBonus = new ArrayList<String>();
	
	public Main() {
		// TODO Auto-generated constructor stub
		Karyawan karyawan1 = new Karyawan("GJ-1901", "Alicia Gabrielle", "Perempuan", "Supervisor", 6000000);
		Karyawan karyawan2 = new Karyawan("AL-0991", "Calvin Nicholas", "Laki-laki", "Supervisor", 6000000);
		Karyawan karyawan3 = new Karyawan("ZZ-1123", "Felix Jonathan", "Laki-laki", "Manager", 8000000);
		Karyawan karyawan4 = new Karyawan("JO-9912", "Herman Kuding", "Laki-laki", "Supervisor", 6000000);
		dataKaryawan.add(karyawan1);
		dataKaryawan.add(karyawan2);
		dataKaryawan.add(karyawan3);
		dataKaryawan.add(karyawan4);
		
		int menu = 0;
		do {
			System.out.println("1. Insert data karyawan");
			System.out.println("2. View data karyawan");
			System.out.println("3. Update data karyawan");
			System.out.println("4. Delete data karyawan");
			System.out.println("5. Exit data karyawan");
			System.out.print(">> ");
			menu = scan.nextInt(); scan.nextLine();
					
			switch (menu) {
			case 1:
				System.out.print("Input nama karyawan [>= 3]: ");
				String nama = scan.nextLine();
				System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				String gender = scan.nextLine();
				System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				String jabatan = scan.nextLine();
				int gaji = 0;
				if(jabatan.equals("Manager")) {
					gaji = 8000000;
				}else if(jabatan.equals("Supervisor")) {
					gaji = 6000000;
				}else if(jabatan.equals("Admin")) {
					gaji = 4000000;
				}
				Random rnd = new Random();
				char m1 = (char) ('A' + rnd.nextInt(26));
				char m2 = (char) ('A' + rnd.nextInt(26));
				int num = rnd.nextInt(10000);
		        String id = String.format("%c%c-%04d", m1, m2, num);
		        Karyawan karyawan5 = new Karyawan(id, nama, gender, jabatan, gaji);
		        dataKaryawan.add(karyawan5);
		        System.out.println("Berhasil menambahkan karyawan baru dengan id " + id);
				for (int i = 0; i < dataKaryawan.size(); i++) {
					Karyawan karyawan = dataKaryawan.get(i); 
					if (karyawan.posisi.equals(jabatan) && (!karyawan.kode.equals(id))) {
						if(jabatan.equals("Manager")) {
							karyawan.gajian *= 1.1;
							dataBonus.add(karyawan.kode);
						}else if(jabatan.equals("Supervisor")) {
							karyawan.gajian *= 1.075;
							dataBonus.add(karyawan.kode);
						}else if(jabatan.equals("Admin")) {
							karyawan.gajian *= 1.05;
							dataBonus.add(karyawan.kode);
						}
					}
				}
				String bonus = "";
				if(jabatan.equals("Manager")) {
					bonus = "10%";
				}else if(jabatan.equals("Supervisor")) {
					bonus = "7,5%";
				}else if(jabatan.equals("Admin")) {
					bonus = "5%";
				}
				
				String dataBonusString = dataBonus.toString().replaceAll("[\\[\\]]", "");
				System.out.println("Bonus sebesar " + bonus + " telah diberikan kepada karyawan dengan id " + dataBonusString);
				dataBonus.clear();
				System.out.println("ENTER to return");
				scan.nextLine();				
				break;
			case 2:
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				Collections.sort(dataKaryawan, Comparator.comparing(karyawan -> karyawan.name));
				for (int i = 0; i < dataKaryawan.size(); i++) {
					System.out.printf("|%4d|", i+1);
					dataKaryawan.get(i).printData();
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("ENTER to return");
				scan.nextLine();
				break;
			case 3:
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				Collections.sort(dataKaryawan, Comparator.comparing(karyawan -> karyawan.name));
				for (int i = 0; i < dataKaryawan.size(); i++) {
					System.out.printf("|%4d|", i+1);
					dataKaryawan.get(i).printData();
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				
				System.out.print("Input nomor urutan karyawan yang ingin diupdate: ");
				int urutan = scan.nextInt() - 1; scan.nextLine();
				
				Karyawan updatedData = dataKaryawan.get(urutan);
				
				if (urutan >= 0 && urutan < dataKaryawan.size()) {
				    System.out.print("Input nama karyawan [>= 3]: ");
				    String newNama = scan.nextLine();
				    if(newNama.equals("0")) {
				    	newNama = dataKaryawan.get(urutan).name;
				    }else {
				    	updatedData.name = newNama;
				    }
				    System.out.print("Input jenis kelamin [Laki-laki | Perempuan] (Case Sensitive): ");
				    String newGender = scan.nextLine();
				    if(newGender.equals("0")) {
				    	newGender = dataKaryawan.get(urutan).jenis;
				    }else {
				    	updatedData.jenis = newGender;
				    }
				    System.out.print("Input jabatan [Manager | Supervisor | Admin] (Case Sensitive): ");
				    String newJabatan = scan.nextLine();
				    if(newJabatan.equals("0")) {
				    	newNama = dataKaryawan.get(urutan).posisi;
				    }else {
				    	updatedData.posisi = newJabatan;
				    	if ("Manager".equals(newJabatan)) {
				            updatedData.gajian = 8000000; 
				        } else if ("Supervisor".equals(newJabatan)) {
				            updatedData.gajian = 6000000; 
				        } else if ("Admin".equals(newJabatan)) {
				            updatedData.gajian = 4000000; 
				        }
				    }
				    System.out.println("Berhasil mengupdate karyawan dengan id " + dataKaryawan.get(urutan).kode);
				}
				System.out.println("ENTER to return");
				scan.nextLine();
				break;
			case 4:
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.println("|No  |Kode Karyawan    |Nama Karyawan                 |Jenis Kelamin  |Jabatan       |Gaji Karyawan|");
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				Collections.sort(dataKaryawan, Comparator.comparing(karyawan -> karyawan.name));
				for (int i = 0; i < dataKaryawan.size(); i++) {
					System.out.printf("|%4d|", i+1);
					dataKaryawan.get(i).printData();
				}
				System.out.println("|----|-----------------|------------------------------|---------------|--------------|-------------|");
				System.out.print("Input nomor urutan karyawan yang ingin dihapus: ");
				int urutan2 = scan.nextInt() - 1; scan.nextLine();
				System.out.println("Karyawan dengan kode " + dataKaryawan.get(urutan2).kode + " berhasil dihapus");
				dataKaryawan.remove(urutan2);
				System.out.println("ENTER to return");
				scan.nextLine();
				break;
			default:
				break;
			}
		}while(menu != 5);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Main();
	}

}
