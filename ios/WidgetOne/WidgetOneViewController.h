//
//  WidgetOneViewController.h
//  NativeComp
//
//  Created by adrian.hartanto on 26/11/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>
#import "WidgetOneViewManager.h"

NS_ASSUME_NONNULL_BEGIN

@interface WidgetOneViewController : UIViewController

- (instancetype)initWithVM:(WidgetOneViewManager *)vm;

@end

NS_ASSUME_NONNULL_END
